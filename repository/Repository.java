package repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private int id;
    private Map<Integer,Person> personMap;

    public Repository(){
        this.id = 0;
        this.personMap = new HashMap<>();
    }
    public void add(Person person){
        this.personMap.putIfAbsent(id++,person);
    }
    public Person get(int id){
       return this.personMap.get(id);
    }
    public boolean update(int id, Person newPerson){
        if (exist(id)) return false;
        this.personMap.put(id,newPerson);
        return true;
    }

    private boolean exist(int id) {
        if (!this.personMap.containsKey(id)) {
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        if (exist(id)) return false;
        this.personMap.remove(id);
        return true;
    }
    public int getCount(){
        return this.personMap.size();
    }
}

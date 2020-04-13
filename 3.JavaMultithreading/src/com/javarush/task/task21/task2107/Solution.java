package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
*/
public class Solution implements Cloneable {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone = solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
    public Solution clone(){
        Solution solutionNew = new Solution();
        for (Map.Entry<String, User> pair : this.users.entrySet()){
            solutionNew.users.put(pair.getKey(), (User)pair.getValue().clone());
        }
        return solutionNew;
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public Object clone(){
            User userNew = new User(this.age, this.name);
            return userNew;
        }

        public int hashCode() {
            return 31 * age + (name == null ? 0 :name.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof User)) return false;
            User tmp = (User) obj;
            if (tmp.age != this.age)
                return false;
            if (tmp.name == null ? this.name != null : !this.name.equals(tmp.name))
                return false;
            return true;
        }
    }
}

package com.company;

import java.util.*;

public class CandidatesList {
    private static ArrayList<Student> candidates = new ArrayList<>();

    public boolean addStudent(Student student){
        if (candidates.contains(student)) {
            return false;
        }
        candidates.add(student);
        return true;
    }

    public boolean removeStudent(Student student){
        if (!candidates.contains(student)) {
            return false;
        }
        candidates.remove(student);
        return true;
    }

    public ArrayList<Student> filter(String location){
        ArrayList<Student> candidatesFiltered = new ArrayList<>();
        for (Student student : candidates) {
            if (Objects.equals(student.getLocation(), location)) candidatesFiltered.add(student);
        }
        return candidatesFiltered;
    }

    public ArrayList<Student> filter(int remote){
        ArrayList<Student> candidatesFiltered = new ArrayList<>();
        for (Student student : candidates) {
            if (student.getRemote() == remote) candidatesFiltered.add(student);
        }
        return candidatesFiltered;
    }

    public ArrayList<Student> filter(boolean transfer){
        ArrayList<Student> candidatesFiltered = new ArrayList<>();
        for (Student student : candidates) {
            if (student.isTransfer() == transfer) candidatesFiltered.add(student);
        }
        return candidatesFiltered;
    }

    public ArrayList<Student> filter(String location, int remote, boolean transfer){
        ArrayList<Student> candidatesFiltered = new ArrayList<>();
        for (Student student : candidates) {
            if (Objects.equals(student.getLocation(), location) &&
                    student.isTransfer() == transfer &&
                    student.getRemote() == remote) candidatesFiltered.add(student);
        }
        return candidatesFiltered;
    }

    public Student findEmail(String email){
        for (Student student : candidates) {
            if (Objects.equals(student.getEmail(), email)) return student;
        } return null;
    }

    public Student findPhone(String phone){
        for (Student student : candidates) {
            if (Objects.equals(student.getPhone(), phone)) return student;
        } return null;
    }

    public static void printTopCities(){
        Map<String, Integer> mapCities = new HashMap<>();
        for (Student student : candidates) {
            int counterCity = 1;
            for (Map.Entry<String, Integer> entry : mapCities.entrySet()) {
                if (Objects.equals(entry.getKey(), student.getLocation()))
                    counterCity = entry.getValue() + 1;
            }
            mapCities.put(student.getLocation(), counterCity);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapCities.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = list.size(); i > 0; i--) {
            System.out.println(list.get(i - 1).getKey() + " => " + list.get(i - 1).getValue());
        }
    }

    public static void printTopCountries(){
        Map<String, Integer> mapCountries = new HashMap<>();
        for (Student student : candidates) {
            int counterCountry = 1;
            for (Map.Entry<String, Integer> entry : mapCountries.entrySet()) {
                if (Objects.equals(entry.getKey(), student.getCountry()))
                    counterCountry = entry.getValue() + 1;
            }
            mapCountries.put(student.getCountry(), counterCountry);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mapCountries.entrySet());
        list.sort(Map.Entry.comparingByValue());
        for (int i = list.size(); i > 0; i--) {
            System.out.println(list.get(i - 1).getKey() + " => " + list.get(i - 1).getValue());
        }
    }

    public int totalRemote() {
        int sumRemote = 0;
        for (Student student : candidates) {
            if (student.getRemote() == 1) sumRemote++;
        }
        return sumRemote;
    }

    public int totalTransfer() {
        int sumTransfer = 0;
        for (Student student : candidates) {
            if (student.isTransfer()) sumTransfer++;
        }
        return sumTransfer;
    }

    public int totalPresentialWOTrasfer() {
        int sumTotal = 0;
        for (Student student : candidates) {
            if (!student.isTransfer() && student.getRemote() == 0) sumTotal++;
        }
        return sumTotal;
    }

}

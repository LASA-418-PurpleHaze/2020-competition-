package frc.robot;

import java.util.*;
public class HazyPath{
    private ArrayList<HazyTrajectory> path;

    public HazyPath(){
        path = new ArrayList<HazyTrajectory>();
    }

    public void addTrajectory(HazyTrajectory traj){
        path.add(traj);
    }

    public ArrayList<HazyTrajectory> getPath(){
        return path;
    }
}
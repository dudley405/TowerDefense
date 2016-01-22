package com.dudley.towerdefense.sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Justin on 1/21/2016.
 */
public class Wave {

    List<List<Group>> groups = new ArrayList<List<Group>>();

    public Wave() {

    }

    public void addGroup(List<Group> group) {
        groups.add(group);
    }

    public boolean isOver(){
        int count = 0;
        int groupListSize = 0;
        for(List<Group> groupList : groups) {
            for (Group group : groupList) {
                groupListSize = groupList.size();
                if (group.isAllNull()) {
                    count++;
                }
            }
        }
        if(count + 1 == groupListSize) {
            return true;
        } else {
            return false;
        }
    }

    public List<List<Group>> getGroups() {
        return this.groups;
    }
}

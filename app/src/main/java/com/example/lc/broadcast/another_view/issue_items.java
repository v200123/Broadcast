package com.example.lc.broadcast.another_view;

import java.util.List;

public  class issue_items {
    private static  List<issue_collection> mCollectionList ;
    public issue_items(List<issue_collection> collectionList) {
        mCollectionList = collectionList;
        for(int i = 0 ; i<50;i++){
            issue_collection  issue_collection = new issue_collection();
            issue_collection.setAnswer(i%2==0);
            issue_collection.setQuestion("你知道你怎么来的么#"+i);
            issue_collection.setIssue_number(i);
            mCollectionList.add(issue_collection);
        }
    }
    public  List<issue_collection> getList(){
                return  mCollectionList;
    }
    public  issue_collection getCollection(int Position){
                return mCollectionList.get(Position);
    }




}

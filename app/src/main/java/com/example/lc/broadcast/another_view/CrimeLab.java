package com.example.lc.broadcast.another_view;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
            private static CrimeLab sCrimeLab;
            private List<Crime> CrimeList ;
            public static CrimeLab get(){
                if(sCrimeLab==null)
                {
                    sCrimeLab = new CrimeLab();
                }
                return sCrimeLab;
            }
       private CrimeLab(){
                CrimeList = new ArrayList<>();
                for (int i =0;i<100;i++){
                    Crime crime =new Crime();
                    crime.setTitle("这是第"+i+"条犯罪记录");
                    crime.setSolved(i%2==0);
                    CrimeList.add(crime);
                }

        }

    public List<Crime> getCrimeList() {
        return CrimeList;
    }
    public Crime getCrime(UUID id) {
                for(Crime crime:CrimeList){
                    if(crime.getUUID().equals(id))
                    {
                        return crime;
                    }
                }
                return null;
    }
}

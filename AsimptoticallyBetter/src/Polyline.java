import javafx.util.Pair;

import java.util.ArrayList;

public class Polyline {
    ArrayList<Pair<Double,Double>> pointList;

    public Polyline() {
        pointList = new ArrayList<>();
    }

    void addPoint(double Latitude,double Longitude){
        pointList.add(new Pair<>(Latitude,Longitude));
    }

    void cleanPoint(){
        pointList = new ArrayList<>();
    }

    void removeLastPoint(){
        pointList.remove(pointList.size()-1);
    }

    String getPolyline(){
        double currentLatitude,currentLongitude;
        currentLatitude = pointList.get(0).getKey();
        currentLongitude = pointList.get(0).getValue();

        int e5Latitude,e5Longitude;


        //Multiply by "1e5"
        e5Latitude = (int) (currentLatitude * 100000);
        e5Longitude = (int) (currentLongitude * 100000);


        //To binary
        ArrayList<Integer> binaryLatitude = new ArrayList<>();
        ArrayList<Integer> binaryLongitude = new ArrayList<>();

        while(e5Latitude > 0){
            binaryLatitude.add(e5Latitude % 2);
            e5Latitude /=2;
        }
        while(e5Longitude > 0){
            binaryLongitude.add(e5Longitude %2);
            e5Longitude /= 2;
        }

        //Left Shift
        for(int i = 0 ; i < binaryLatitude.size() - 1 ; i++)
            binaryLatitude.set(i,binaryLatitude.get(i+1));
        for(int i = 0 ; i < binaryLongitude.size() - 1 ; i++)
            binaryLongitude.set(i,binaryLongitude.get(i+1));

        //Reverse
        ArrayList<Integer> reverseLatitude = new ArrayList<>(binaryLatitude.size());
        ArrayList<Integer> reverseLongitude = new ArrayList<>(binaryLongitude.size());

        for(int i=binaryLatitude.size() - 1; i >= 0; i-=5){
            int j = i - 4 >= 0 ? i - 4 : 0;

            //Or with 0X20
            if(i-4 > 0)
                reverseLatitude.add(1);
            else{
                int size = 6 - i + 1;
                for(int k=0; k < size; k++)
                    reverseLatitude.add(0);
            }

            for(;j<=i; j++)
                reverseLatitude.add(binaryLatitude.get(j));
        }

        for(int i=binaryLongitude.size() - 1; i >= 0; i-=5) {
            int j = i - 4 >= 0 ? i - 4 : 0;


            //Or with 0X20
            if (i - 4 > 0)
                reverseLongitude.add(1);
            else {
                int size = 6 - i + 1;
                for (int k = 0; k < size; k++)
                    reverseLongitude.add(0);
            }


            for (; j <= i; j++)
                reverseLongitude.add(binaryLongitude.get(j));
        }


        //To decimal
        ArrayList<Integer> decimalLatitude = new ArrayList<>();
        ArrayList<Integer> decimalLongitude =  new ArrayList<>();

        for(int i=0;i<reverseLatitude.size();i+=6){

            for(int j=i; j < i+6; j++)
        }


        //add 63


        //to ASCII


        return null;
    }
}

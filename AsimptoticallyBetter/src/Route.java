import java.util.ArrayList;

public class Route {
    ArrayList<Step> steps;
    String overview_polyline;
    double preferenceFactor;
    int time;

    public Route(String overview_polyline, double preferenceFactor,int time) {
        steps = new ArrayList<>();
        this.preferenceFactor = preferenceFactor;
        this.overview_polyline = overview_polyline.replaceAll("\\\\","\\");
        this.time = time;

    }

    public void addStep(Step step){
        steps.add(step);
    }

    public String getOverview_polyline() {
        return overview_polyline;
    }

    double getMetric(){
        return preferenceFactor;
    }
}

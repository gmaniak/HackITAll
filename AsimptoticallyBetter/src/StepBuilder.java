public class StepBuilder {
    private Step step;

    private StepBuilder() {
        this.step = new Step();
    }

    public static StepBuilder create(){
        return new StepBuilder();
    }

    public StepBuilder withStartLocation(double latitude,double longitude){
        this.step.startLatitude=latitude;
        this.step.startLongitude=longitude;
        return this;
    }

    public StepBuilder withEndLocation(double latitude, double longitude){
        this.step.endLatitude = latitude;
        this.step.endLongitude = longitude;
        return this;
    }

    public StepBuilder withDistance(double distance){
        this.step.distance=distance;
        return this;
    }

    public StepBuilder withTime(double time){
        this.step.duration = time;
        return this;
    }

    public Step build(){
        Step buffer = step;
        this.step = null;
        return buffer;
    }
}

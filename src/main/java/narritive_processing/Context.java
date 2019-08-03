package narritive_processing;

import narritive_model.*;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private static Context context;
    private static Map<String, Entity> entities;
    private static Relationship relationship;
    private static Location location;
    private static Scene scene;
    private static ModelObject mostRecentModelObjectUpdated;
    private static boolean mostRecentlyUpdatedIsOther;
    private int segmentsAnalysed = 0;

    public static Context getContext() {
        if (context == null) {
            context = new Context();
            context.setContext(new Entity("Default", "MALE"), null, null, null);
        }

        return context;
    }

    private Context() {
        this.entities = new HashMap<String, Entity>();
        this.location = new Location("");
        this.relationship = null;
        this.scene = new Scene(new BookLocation(this.segmentsAnalysed, 0, 0));
    }

    public void setContext(Entity entity, Location location, Relationship relationship, Scene scene) {
        this.entities.put(entity.getGender(), entity);
        this.location = location;
        this.relationship = relationship;
        this.scene = scene;

        if(entities != null) {
            this.mostRecentModelObjectUpdated = entity;
            if(entity.getGender().equals(Analyser.genders.get(2))) {
                this.mostRecentlyUpdatedIsOther = true;
            } else {
                this.mostRecentlyUpdatedIsOther = false;
            }
        } else if(location != null) {
            this.mostRecentModelObjectUpdated = location;
        }
    }

    public Entity getContextEntity(String entityType) {
        return this.entities.get(entityType);
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public Location getLocation() {
        return location;
    }

    public Scene getScene() {
        return scene;
    }

    public int getSegmentsAnalysed() {
        return segmentsAnalysed;
    }

    public void setSegmentsAnalysed(int segmentsAnalysed) {
        this.segmentsAnalysed = segmentsAnalysed;
    }

    public ModelObject getMostRecentModelObjectUpdated() {
        return this.mostRecentModelObjectUpdated;
    }

    public boolean isMostRecentlyUpdatedIsOther() { return this.mostRecentlyUpdatedIsOther; }
}

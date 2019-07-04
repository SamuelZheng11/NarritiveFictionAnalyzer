package narritive_model;

import java.util.HashSet;
import java.util.Set;

public class Scene {
    private Set<Location> sceneLocations = new HashSet<Location>();
    private Set<Entity> sceneEntities = new HashSet<Entity>();

    public void addLocationToScene(Location location) {
        this.sceneLocations.add(location);
    }

    public void addEntityToScene(Entity entity) {
        this.sceneEntities.add(entity);
    }
}
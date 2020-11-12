
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Other {

    @SerializedName("dream_world")
    @Expose
    private DreamWorld dreamWorld;
    @SerializedName("official-artwork")
    @Expose
    private OfficialArtwork officialArtwork;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Other() {
    }

    /**
     * 
     * @param officialArtwork
     * @param dreamWorld
     */
    public Other(DreamWorld dreamWorld, OfficialArtwork officialArtwork) {
        super();
        this.dreamWorld = dreamWorld;
        this.officialArtwork = officialArtwork;
    }

    public DreamWorld getDreamWorld() {
        return dreamWorld;
    }

    public void setDreamWorld(DreamWorld dreamWorld) {
        this.dreamWorld = dreamWorld;
    }

    public OfficialArtwork getOfficialArtwork() {
        return officialArtwork;
    }

    public void setOfficialArtwork(OfficialArtwork officialArtwork) {
        this.officialArtwork = officialArtwork;
    }

}

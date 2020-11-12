
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameIndex {

    @SerializedName("game_index")
    @Expose
    private Integer gameIndex;
    @SerializedName("version")
    @Expose
    private Version version;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GameIndex() {
    }

    /**
     * 
     * @param gameIndex
     * @param version
     */
    public GameIndex(Integer gameIndex, Version version) {
        super();
        this.gameIndex = gameIndex;
        this.version = version;
    }

    public Integer getGameIndex() {
        return gameIndex;
    }

    public void setGameIndex(Integer gameIndex) {
        this.gameIndex = gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

}

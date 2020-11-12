
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionDetail {

    @SerializedName("rarity")
    @Expose
    private Integer rarity;
    @SerializedName("version")
    @Expose
    private Version_ version;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VersionDetail() {
    }

    /**
     * 
     * @param version
     * @param rarity
     */
    public VersionDetail(Integer rarity, Version_ version) {
        super();
        this.rarity = rarity;
        this.version = version;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Version_ getVersion() {
        return version;
    }

    public void setVersion(Version_ version) {
        this.version = version;
    }

}

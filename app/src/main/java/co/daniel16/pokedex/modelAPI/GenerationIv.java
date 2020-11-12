
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationIv {

    @SerializedName("diamond-pearl")
    @Expose
    private DiamondPearl diamondPearl;
    @SerializedName("heartgold-soulsilver")
    @Expose
    private HeartgoldSoulsilver heartgoldSoulsilver;
    @SerializedName("platinum")
    @Expose
    private Platinum platinum;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationIv() {
    }

    /**
     * 
     * @param platinum
     * @param heartgoldSoulsilver
     * @param diamondPearl
     */
    public GenerationIv(DiamondPearl diamondPearl, HeartgoldSoulsilver heartgoldSoulsilver, Platinum platinum) {
        super();
        this.diamondPearl = diamondPearl;
        this.heartgoldSoulsilver = heartgoldSoulsilver;
        this.platinum = platinum;
    }

    public DiamondPearl getDiamondPearl() {
        return diamondPearl;
    }

    public void setDiamondPearl(DiamondPearl diamondPearl) {
        this.diamondPearl = diamondPearl;
    }

    public HeartgoldSoulsilver getHeartgoldSoulsilver() {
        return heartgoldSoulsilver;
    }

    public void setHeartgoldSoulsilver(HeartgoldSoulsilver heartgoldSoulsilver) {
        this.heartgoldSoulsilver = heartgoldSoulsilver;
    }

    public Platinum getPlatinum() {
        return platinum;
    }

    public void setPlatinum(Platinum platinum) {
        this.platinum = platinum;
    }

}

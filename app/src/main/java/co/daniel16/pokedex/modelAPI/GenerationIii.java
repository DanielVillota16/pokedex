
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationIii {

    @SerializedName("emerald")
    @Expose
    private Emerald emerald;
    @SerializedName("firered-leafgreen")
    @Expose
    private FireredLeafgreen fireredLeafgreen;
    @SerializedName("ruby-sapphire")
    @Expose
    private RubySapphire rubySapphire;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationIii() {
    }

    /**
     * 
     * @param fireredLeafgreen
     * @param rubySapphire
     * @param emerald
     */
    public GenerationIii(Emerald emerald, FireredLeafgreen fireredLeafgreen, RubySapphire rubySapphire) {
        super();
        this.emerald = emerald;
        this.fireredLeafgreen = fireredLeafgreen;
        this.rubySapphire = rubySapphire;
    }

    public Emerald getEmerald() {
        return emerald;
    }

    public void setEmerald(Emerald emerald) {
        this.emerald = emerald;
    }

    public FireredLeafgreen getFireredLeafgreen() {
        return fireredLeafgreen;
    }

    public void setFireredLeafgreen(FireredLeafgreen fireredLeafgreen) {
        this.fireredLeafgreen = fireredLeafgreen;
    }

    public RubySapphire getRubySapphire() {
        return rubySapphire;
    }

    public void setRubySapphire(RubySapphire rubySapphire) {
        this.rubySapphire = rubySapphire;
    }

}

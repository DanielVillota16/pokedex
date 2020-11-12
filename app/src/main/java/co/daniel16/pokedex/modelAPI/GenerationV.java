
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GenerationV {

    @SerializedName("black-white")
    @Expose
    private BlackWhite blackWhite;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GenerationV() {
    }

    /**
     * 
     * @param blackWhite
     */
    public GenerationV(BlackWhite blackWhite) {
        super();
        this.blackWhite = blackWhite;
    }

    public BlackWhite getBlackWhite() {
        return blackWhite;
    }

    public void setBlackWhite(BlackWhite blackWhite) {
        this.blackWhite = blackWhite;
    }

}

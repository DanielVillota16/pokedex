
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sprites {

    @SerializedName("back_female")
    @Expose
    private String backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private String backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private String frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private String frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;
    @SerializedName("other")
    @Expose
    private Other other;
    @SerializedName("versions")
    @Expose
    private Versions versions;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Sprites() {
    }

    /**
     * 
     * @param frontShinyFemale
     * @param other
     * @param backFemale
     * @param versions
     * @param frontShiny
     * @param backDefault
     * @param frontDefault
     * @param frontFemale
     * @param backShinyFemale
     * @param backShiny
     */
    public Sprites(String backFemale, String backShinyFemale, String backDefault, String frontFemale, String frontShinyFemale, String backShiny, String frontDefault, String frontShiny, Other other, Versions versions) {
        super();
        this.backFemale = backFemale;
        this.backShinyFemale = backShinyFemale;
        this.backDefault = backDefault;
        this.frontFemale = frontFemale;
        this.frontShinyFemale = frontShinyFemale;
        this.backShiny = backShiny;
        this.frontDefault = frontDefault;
        this.frontShiny = frontShiny;
        this.other = other;
        this.versions = versions;
    }

    public String getBackFemale() {
        return backFemale;
    }

    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    public String getFrontDefault() {
        return frontDefault;
    }

    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public Other getOther() {
        return other;
    }

    public void setOther(Other other) {
        this.other = other;
    }

    public Versions getVersions() {
        return versions;
    }

    public void setVersions(Versions versions) {
        this.versions = versions;
    }

}

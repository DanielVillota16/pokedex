
package co.daniel16.pokedex.modelAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stat {

    @SerializedName("base_stat")
    @Expose
    private Integer baseStat;
    @SerializedName("effort")
    @Expose
    private Integer effort;
    @SerializedName("stat")
    @Expose
    private Stat_ stat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Stat() {
    }

    /**
     * 
     * @param stat
     * @param baseStat
     * @param effort
     */
    public Stat(Integer baseStat, Integer effort, Stat_ stat) {
        super();
        this.baseStat = baseStat;
        this.effort = effort;
        this.stat = stat;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

    public void setBaseStat(Integer baseStat) {
        this.baseStat = baseStat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public Stat_ getStat() {
        return stat;
    }

    public void setStat(Stat_ stat) {
        this.stat = stat;
    }

}

package com.ncaapredictor.demo.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

    @Id 
    private String id;

    @Indexed
    private String teamName;

    private double off_rtg;

    private double def_rtg;

    private double pace;

    private double ft_rate;

    private double three_fg_trend;

    private double ts_percent;

    private double efg_percent;

    private double to_percent;

    private double off_reb_percent;

    private double ft_over_fga;

    private double efg_percent_allow;

    private double to_percent_allow;

    private double def_reb_percent_allow;

    private double ft_over_fga_allow;

    // public Team(String teamName, double off_rtg, double def_rtg, double pace, double ft_rate, double three_fg_trend,
    // double ts_percent, double efg_percent, double to_percent, double off_reb_percent, double ft_fga,
    // double efg_percent_allow, double to_percent_allow, double def_reb_percent_allow, double ft_fga_allow) {
    //     this.teamName = teamName;
    //     this.off_rtg = off_rtg;
    //     this.def_rtg = def_rtg;
    //     this.pace = pace;
    //     this.ft_rate = ft_rate;
    //     this.three_fg_trend = three_fg_trend;
    //     this.ts_percent = ts_percent;
    //     this.efg_percent = efg_percent;
    //     this.to_percent = to_percent;
    //     this.off_reb_percent = off_reb_percent;
    //     this.ft_fga = ft_fga;
    //     this.efg_percent_allow = efg_percent_allow;
    //     this.to_percent_allow = to_percent_allow;
    //     this.def_reb_percent_allow = def_reb_percent_allow;
    //     this.ft_fga_allow = ft_fga_allow;
    // }

    public String getTeamName() {
        return teamName;
    }

    public double getOffRtg() {
        return off_rtg;
    }

    public double getDefRtg() {
        return def_rtg;
    }

    public double getPace() {
        return pace;
    }

    public double getFtRate() {
        return ft_rate;
    }

    public double getThreeFgTrend() {
        return three_fg_trend;
    }

    public double getTsPercent() {
        return ts_percent;
    }

    public double getEfgPercent() {
        return efg_percent;
    }

    public double getToPercent() {
        return to_percent;
    }

    public double getOffRebPercent() {
        return off_reb_percent;
    }

    public double getFtFga() {
        return ft_over_fga;
    }

    public double getEfgPercentAllow() {
        return efg_percent_allow;
    }

    public double getToPercentAllow() {
        return to_percent_allow;
    }

    public double getDefRebPercentAllow() {
        return def_reb_percent_allow;
    }

    public double getFtFgaAllow() {
        return ft_over_fga_allow;
    }
}
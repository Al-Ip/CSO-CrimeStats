/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author k00229834
 */
@Entity
@Table(name = "crime")
@NamedQueries({
    @NamedQuery(name = "Crime.findAll", query = "SELECT c FROM Crime c")})
public class Crime implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "Region")
    private String region;
    @Column(name = "GardaDivision")
    private String gardaDivision;
    @Column(name = "OffenceCode")
    private Integer offenceCode;
    @Column(name = "Offence")
    private String offence;
    @Column(name = "TypeOfOffence")
    private String typeOfOffence;
    @Column(name = "2003Q1")
    private Integer q1;
    @Column(name = "2003Q2")
    private Integer q2;
    @Column(name = "2003Q3")
    private Integer q3;
    @Column(name = "2003Q4")
    private Integer q4;
    @Column(name = "2004Q1")
    private Integer q11;
    @Column(name = "2004Q2")
    private Integer q21;
    @Column(name = "2004Q3")
    private Integer q31;
    @Column(name = "2004Q4")
    private Integer q41;
    @Column(name = "2005Q1")
    private Integer q12;
    @Column(name = "2005Q2")
    private Integer q22;
    @Column(name = "2005Q3")
    private Integer q32;
    @Column(name = "2005Q4")
    private Integer q42;
    @Column(name = "2006Q1")
    private Integer q13;
    @Column(name = "2006Q2")
    private Integer q23;
    @Column(name = "2006Q3")
    private Integer q33;
    @Column(name = "2006Q4")
    private Integer q43;
    @Column(name = "2007Q1")
    private Integer q14;
    @Column(name = "2007Q2")
    private Integer q24;
    @Column(name = "2007Q3")
    private Integer q34;
    @Column(name = "2007Q4")
    private Integer q44;
    @Column(name = "2008Q1")
    private Integer q15;
    @Column(name = "2008Q2")
    private Integer q25;
    @Column(name = "2008Q3")
    private Integer q35;
    @Column(name = "2008Q4")
    private Integer q45;
    @Column(name = "2009Q1")
    private Integer q16;
    @Column(name = "2009Q2")
    private Integer q26;
    @Column(name = "2009Q3")
    private Integer q36;
    @Column(name = "2009Q4")
    private Integer q46;
    @Column(name = "2010Q1")
    private Integer q17;
    @Column(name = "2010Q2")
    private Integer q27;
    @Column(name = "2010Q3")
    private Integer q37;
    @Column(name = "2010Q4")
    private Integer q47;
    @Column(name = "2011Q1")
    private Integer q18;
    @Column(name = "2011Q2")
    private Integer q28;
    @Column(name = "2011Q3")
    private Integer q38;
    @Column(name = "2011Q4")
    private Integer q48;
    @Column(name = "2012Q1")
    private Integer q19;
    @Column(name = "2012Q2")
    private Integer q29;
    @Column(name = "2012Q3")
    private Integer q39;
    @Column(name = "2012Q4")
    private Integer q49;
    @Column(name = "2013Q1")
    private Integer q110;
    @Column(name = "2013Q2")
    private Integer q210;
    @Column(name = "2013Q3")
    private Integer q310;
    @Column(name = "2013Q4")
    private Integer q410;
    @Column(name = "2014Q1")
    private Integer q111;
    @Column(name = "2014Q2")
    private Integer q211;
    @Column(name = "2014Q3")
    private Integer q311;
    @Column(name = "2014Q4")
    private Integer q411;
    @Column(name = "2015Q1")
    private Integer q112;
    @Column(name = "2015Q2")
    private Integer q212;
    @Column(name = "2015Q3")
    private Integer q312;
    @Column(name = "2015Q4")
    private Integer q412;
    @Column(name = "2016Q1")
    private Integer q113;
    @Column(name = "2016Q2")
    private Integer q213;
    @Column(name = "2016Q3")
    private Integer q313;
    @Column(name = "2016Q4")
    private Integer q413;
    @Column(name = "2017Q1")
    private Integer q114;
    @Column(name = "2017Q2")
    private Integer q214;
    @Column(name = "2017Q3")
    private Integer q314;
    @Column(name = "2017Q4")
    private Integer q414;
    @Column(name = "2018Q1")
    private Integer q115;
    @Column(name = "2018Q2")
    private Integer q215;
    @Column(name = "2018Q3")
    private Integer q315;
    @Column(name = "2018Q4")
    private Integer q415;
    @Column(name = "2019Q1")
    private Integer q116;
    @Column(name = "2019Q2")
    private Integer q216;
    @Column(name = "2019Q3")
    private Integer q316;

    public Crime() {
    }

    public Crime(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        String oldRegion = this.region;
        this.region = region;
        changeSupport.firePropertyChange("region", oldRegion, region);
    }

    public String getGardaDivision() {
        return gardaDivision;
    }

    public void setGardaDivision(String gardaDivision) {
        String oldGardaDivision = this.gardaDivision;
        this.gardaDivision = gardaDivision;
        changeSupport.firePropertyChange("gardaDivision", oldGardaDivision, gardaDivision);
    }

    public Integer getOffenceCode() {
        return offenceCode;
    }

    public void setOffenceCode(Integer offenceCode) {
        Integer oldOffenceCode = this.offenceCode;
        this.offenceCode = offenceCode;
        changeSupport.firePropertyChange("offenceCode", oldOffenceCode, offenceCode);
    }

    public String getOffence() {
        return offence;
    }

    public void setOffence(String offence) {
        String oldOffence = this.offence;
        this.offence = offence;
        changeSupport.firePropertyChange("offence", oldOffence, offence);
    }

    public String getTypeOfOffence() {
        return typeOfOffence;
    }

    public void setTypeOfOffence(String typeOfOffence) {
        String oldTypeOfOffence = this.typeOfOffence;
        this.typeOfOffence = typeOfOffence;
        changeSupport.firePropertyChange("typeOfOffence", oldTypeOfOffence, typeOfOffence);
    }

    public Integer getQ1() {
        return q1;
    }

    public void setQ1(Integer q1) {
        Integer oldQ1 = this.q1;
        this.q1 = q1;
        changeSupport.firePropertyChange("Q1", oldQ1, q1);
    }

    public Integer getQ2() {
        return q2;
    }

    public void setQ2(Integer q2) {
        Integer oldQ2 = this.q2;
        this.q2 = q2;
        changeSupport.firePropertyChange("Q2", oldQ2, q2);
    }

    public Integer getQ3() {
        return q3;
    }

    public void setQ3(Integer q3) {
        Integer oldQ3 = this.q3;
        this.q3 = q3;
        changeSupport.firePropertyChange("Q3", oldQ3, q3);
    }

    public Integer getQ4() {
        return q4;
    }

    public void setQ4(Integer q4) {
        Integer oldQ4 = this.q4;
        this.q4 = q4;
        changeSupport.firePropertyChange("Q4", oldQ4, q4);
    }

    public Integer getQ11() {
        return q11;
    }

    public void setQ11(Integer q11) {
        Integer oldQ11 = this.q11;
        this.q11 = q11;
        changeSupport.firePropertyChange("Q11", oldQ11, q11);
    }

    public Integer getQ21() {
        return q21;
    }

    public void setQ21(Integer q21) {
        Integer oldQ21 = this.q21;
        this.q21 = q21;
        changeSupport.firePropertyChange("Q21", oldQ21, q21);
    }

    public Integer getQ31() {
        return q31;
    }

    public void setQ31(Integer q31) {
        Integer oldQ31 = this.q31;
        this.q31 = q31;
        changeSupport.firePropertyChange("Q31", oldQ31, q31);
    }

    public Integer getQ41() {
        return q41;
    }

    public void setQ41(Integer q41) {
        Integer oldQ41 = this.q41;
        this.q41 = q41;
        changeSupport.firePropertyChange("Q41", oldQ41, q41);
    }

    public Integer getQ12() {
        return q12;
    }

    public void setQ12(Integer q12) {
        Integer oldQ12 = this.q12;
        this.q12 = q12;
        changeSupport.firePropertyChange("Q12", oldQ12, q12);
    }

    public Integer getQ22() {
        return q22;
    }

    public void setQ22(Integer q22) {
        Integer oldQ22 = this.q22;
        this.q22 = q22;
        changeSupport.firePropertyChange("Q22", oldQ22, q22);
    }

    public Integer getQ32() {
        return q32;
    }

    public void setQ32(Integer q32) {
        Integer oldQ32 = this.q32;
        this.q32 = q32;
        changeSupport.firePropertyChange("Q32", oldQ32, q32);
    }

    public Integer getQ42() {
        return q42;
    }

    public void setQ42(Integer q42) {
        Integer oldQ42 = this.q42;
        this.q42 = q42;
        changeSupport.firePropertyChange("Q42", oldQ42, q42);
    }

    public Integer getQ13() {
        return q13;
    }

    public void setQ13(Integer q13) {
        Integer oldQ13 = this.q13;
        this.q13 = q13;
        changeSupport.firePropertyChange("Q13", oldQ13, q13);
    }

    public Integer getQ23() {
        return q23;
    }

    public void setQ23(Integer q23) {
        Integer oldQ23 = this.q23;
        this.q23 = q23;
        changeSupport.firePropertyChange("Q23", oldQ23, q23);
    }

    public Integer getQ33() {
        return q33;
    }

    public void setQ33(Integer q33) {
        Integer oldQ33 = this.q33;
        this.q33 = q33;
        changeSupport.firePropertyChange("Q33", oldQ33, q33);
    }

    public Integer getQ43() {
        return q43;
    }

    public void setQ43(Integer q43) {
        Integer oldQ43 = this.q43;
        this.q43 = q43;
        changeSupport.firePropertyChange("Q43", oldQ43, q43);
    }

    public Integer getQ14() {
        return q14;
    }

    public void setQ14(Integer q14) {
        Integer oldQ14 = this.q14;
        this.q14 = q14;
        changeSupport.firePropertyChange("Q14", oldQ14, q14);
    }

    public Integer getQ24() {
        return q24;
    }

    public void setQ24(Integer q24) {
        Integer oldQ24 = this.q24;
        this.q24 = q24;
        changeSupport.firePropertyChange("Q24", oldQ24, q24);
    }

    public Integer getQ34() {
        return q34;
    }

    public void setQ34(Integer q34) {
        Integer oldQ34 = this.q34;
        this.q34 = q34;
        changeSupport.firePropertyChange("Q34", oldQ34, q34);
    }

    public Integer getQ44() {
        return q44;
    }

    public void setQ44(Integer q44) {
        Integer oldQ44 = this.q44;
        this.q44 = q44;
        changeSupport.firePropertyChange("Q44", oldQ44, q44);
    }

    public Integer getQ15() {
        return q15;
    }

    public void setQ15(Integer q15) {
        Integer oldQ15 = this.q15;
        this.q15 = q15;
        changeSupport.firePropertyChange("Q15", oldQ15, q15);
    }

    public Integer getQ25() {
        return q25;
    }

    public void setQ25(Integer q25) {
        Integer oldQ25 = this.q25;
        this.q25 = q25;
        changeSupport.firePropertyChange("Q25", oldQ25, q25);
    }

    public Integer getQ35() {
        return q35;
    }

    public void setQ35(Integer q35) {
        Integer oldQ35 = this.q35;
        this.q35 = q35;
        changeSupport.firePropertyChange("Q35", oldQ35, q35);
    }

    public Integer getQ45() {
        return q45;
    }

    public void setQ45(Integer q45) {
        Integer oldQ45 = this.q45;
        this.q45 = q45;
        changeSupport.firePropertyChange("Q45", oldQ45, q45);
    }

    public Integer getQ16() {
        return q16;
    }

    public void setQ16(Integer q16) {
        Integer oldQ16 = this.q16;
        this.q16 = q16;
        changeSupport.firePropertyChange("Q16", oldQ16, q16);
    }

    public Integer getQ26() {
        return q26;
    }

    public void setQ26(Integer q26) {
        Integer oldQ26 = this.q26;
        this.q26 = q26;
        changeSupport.firePropertyChange("Q26", oldQ26, q26);
    }

    public Integer getQ36() {
        return q36;
    }

    public void setQ36(Integer q36) {
        Integer oldQ36 = this.q36;
        this.q36 = q36;
        changeSupport.firePropertyChange("Q36", oldQ36, q36);
    }

    public Integer getQ46() {
        return q46;
    }

    public void setQ46(Integer q46) {
        Integer oldQ46 = this.q46;
        this.q46 = q46;
        changeSupport.firePropertyChange("Q46", oldQ46, q46);
    }

    public Integer getQ17() {
        return q17;
    }

    public void setQ17(Integer q17) {
        Integer oldQ17 = this.q17;
        this.q17 = q17;
        changeSupport.firePropertyChange("Q17", oldQ17, q17);
    }

    public Integer getQ27() {
        return q27;
    }

    public void setQ27(Integer q27) {
        Integer oldQ27 = this.q27;
        this.q27 = q27;
        changeSupport.firePropertyChange("Q27", oldQ27, q27);
    }

    public Integer getQ37() {
        return q37;
    }

    public void setQ37(Integer q37) {
        Integer oldQ37 = this.q37;
        this.q37 = q37;
        changeSupport.firePropertyChange("Q37", oldQ37, q37);
    }

    public Integer getQ47() {
        return q47;
    }

    public void setQ47(Integer q47) {
        Integer oldQ47 = this.q47;
        this.q47 = q47;
        changeSupport.firePropertyChange("Q47", oldQ47, q47);
    }

    public Integer getQ18() {
        return q18;
    }

    public void setQ18(Integer q18) {
        Integer oldQ18 = this.q18;
        this.q18 = q18;
        changeSupport.firePropertyChange("Q18", oldQ18, q18);
    }

    public Integer getQ28() {
        return q28;
    }

    public void setQ28(Integer q28) {
        Integer oldQ28 = this.q28;
        this.q28 = q28;
        changeSupport.firePropertyChange("Q28", oldQ28, q28);
    }

    public Integer getQ38() {
        return q38;
    }

    public void setQ38(Integer q38) {
        Integer oldQ38 = this.q38;
        this.q38 = q38;
        changeSupport.firePropertyChange("Q38", oldQ38, q38);
    }

    public Integer getQ48() {
        return q48;
    }

    public void setQ48(Integer q48) {
        Integer oldQ48 = this.q48;
        this.q48 = q48;
        changeSupport.firePropertyChange("Q48", oldQ48, q48);
    }

    public Integer getQ19() {
        return q19;
    }

    public void setQ19(Integer q19) {
        Integer oldQ19 = this.q19;
        this.q19 = q19;
        changeSupport.firePropertyChange("Q19", oldQ19, q19);
    }

    public Integer getQ29() {
        return q29;
    }

    public void setQ29(Integer q29) {
        Integer oldQ29 = this.q29;
        this.q29 = q29;
        changeSupport.firePropertyChange("Q29", oldQ29, q29);
    }

    public Integer getQ39() {
        return q39;
    }

    public void setQ39(Integer q39) {
        Integer oldQ39 = this.q39;
        this.q39 = q39;
        changeSupport.firePropertyChange("Q39", oldQ39, q39);
    }

    public Integer getQ49() {
        return q49;
    }

    public void setQ49(Integer q49) {
        Integer oldQ49 = this.q49;
        this.q49 = q49;
        changeSupport.firePropertyChange("Q49", oldQ49, q49);
    }

    public Integer getQ110() {
        return q110;
    }

    public void setQ110(Integer q110) {
        Integer oldQ110 = this.q110;
        this.q110 = q110;
        changeSupport.firePropertyChange("Q110", oldQ110, q110);
    }

    public Integer getQ210() {
        return q210;
    }

    public void setQ210(Integer q210) {
        Integer oldQ210 = this.q210;
        this.q210 = q210;
        changeSupport.firePropertyChange("Q210", oldQ210, q210);
    }

    public Integer getQ310() {
        return q310;
    }

    public void setQ310(Integer q310) {
        Integer oldQ310 = this.q310;
        this.q310 = q310;
        changeSupport.firePropertyChange("Q310", oldQ310, q310);
    }

    public Integer getQ410() {
        return q410;
    }

    public void setQ410(Integer q410) {
        Integer oldQ410 = this.q410;
        this.q410 = q410;
        changeSupport.firePropertyChange("Q410", oldQ410, q410);
    }

    public Integer getQ111() {
        return q111;
    }

    public void setQ111(Integer q111) {
        Integer oldQ111 = this.q111;
        this.q111 = q111;
        changeSupport.firePropertyChange("Q111", oldQ111, q111);
    }

    public Integer getQ211() {
        return q211;
    }

    public void setQ211(Integer q211) {
        Integer oldQ211 = this.q211;
        this.q211 = q211;
        changeSupport.firePropertyChange("Q211", oldQ211, q211);
    }

    public Integer getQ311() {
        return q311;
    }

    public void setQ311(Integer q311) {
        Integer oldQ311 = this.q311;
        this.q311 = q311;
        changeSupport.firePropertyChange("Q311", oldQ311, q311);
    }

    public Integer getQ411() {
        return q411;
    }

    public void setQ411(Integer q411) {
        Integer oldQ411 = this.q411;
        this.q411 = q411;
        changeSupport.firePropertyChange("Q411", oldQ411, q411);
    }

    public Integer getQ112() {
        return q112;
    }

    public void setQ112(Integer q112) {
        Integer oldQ112 = this.q112;
        this.q112 = q112;
        changeSupport.firePropertyChange("Q112", oldQ112, q112);
    }

    public Integer getQ212() {
        return q212;
    }

    public void setQ212(Integer q212) {
        Integer oldQ212 = this.q212;
        this.q212 = q212;
        changeSupport.firePropertyChange("Q212", oldQ212, q212);
    }

    public Integer getQ312() {
        return q312;
    }

    public void setQ312(Integer q312) {
        Integer oldQ312 = this.q312;
        this.q312 = q312;
        changeSupport.firePropertyChange("Q312", oldQ312, q312);
    }

    public Integer getQ412() {
        return q412;
    }

    public void setQ412(Integer q412) {
        Integer oldQ412 = this.q412;
        this.q412 = q412;
        changeSupport.firePropertyChange("Q412", oldQ412, q412);
    }

    public Integer getQ113() {
        return q113;
    }

    public void setQ113(Integer q113) {
        Integer oldQ113 = this.q113;
        this.q113 = q113;
        changeSupport.firePropertyChange("Q113", oldQ113, q113);
    }

    public Integer getQ213() {
        return q213;
    }

    public void setQ213(Integer q213) {
        Integer oldQ213 = this.q213;
        this.q213 = q213;
        changeSupport.firePropertyChange("Q213", oldQ213, q213);
    }

    public Integer getQ313() {
        return q313;
    }

    public void setQ313(Integer q313) {
        Integer oldQ313 = this.q313;
        this.q313 = q313;
        changeSupport.firePropertyChange("Q313", oldQ313, q313);
    }

    public Integer getQ413() {
        return q413;
    }

    public void setQ413(Integer q413) {
        Integer oldQ413 = this.q413;
        this.q413 = q413;
        changeSupport.firePropertyChange("Q413", oldQ413, q413);
    }

    public Integer getQ114() {
        return q114;
    }

    public void setQ114(Integer q114) {
        Integer oldQ114 = this.q114;
        this.q114 = q114;
        changeSupport.firePropertyChange("Q114", oldQ114, q114);
    }

    public Integer getQ214() {
        return q214;
    }

    public void setQ214(Integer q214) {
        Integer oldQ214 = this.q214;
        this.q214 = q214;
        changeSupport.firePropertyChange("Q214", oldQ214, q214);
    }

    public Integer getQ314() {
        return q314;
    }

    public void setQ314(Integer q314) {
        Integer oldQ314 = this.q314;
        this.q314 = q314;
        changeSupport.firePropertyChange("Q314", oldQ314, q314);
    }

    public Integer getQ414() {
        return q414;
    }

    public void setQ414(Integer q414) {
        Integer oldQ414 = this.q414;
        this.q414 = q414;
        changeSupport.firePropertyChange("Q414", oldQ414, q414);
    }

    public Integer getQ115() {
        return q115;
    }

    public void setQ115(Integer q115) {
        Integer oldQ115 = this.q115;
        this.q115 = q115;
        changeSupport.firePropertyChange("Q115", oldQ115, q115);
    }

    public Integer getQ215() {
        return q215;
    }

    public void setQ215(Integer q215) {
        Integer oldQ215 = this.q215;
        this.q215 = q215;
        changeSupport.firePropertyChange("Q215", oldQ215, q215);
    }

    public Integer getQ315() {
        return q315;
    }

    public void setQ315(Integer q315) {
        Integer oldQ315 = this.q315;
        this.q315 = q315;
        changeSupport.firePropertyChange("Q315", oldQ315, q315);
    }

    public Integer getQ415() {
        return q415;
    }

    public void setQ415(Integer q415) {
        Integer oldQ415 = this.q415;
        this.q415 = q415;
        changeSupport.firePropertyChange("Q415", oldQ415, q415);
    }

    public Integer getQ116() {
        return q116;
    }

    public void setQ116(Integer q116) {
        Integer oldQ116 = this.q116;
        this.q116 = q116;
        changeSupport.firePropertyChange("Q116", oldQ116, q116);
    }

    public Integer getQ216() {
        return q216;
    }

    public void setQ216(Integer q216) {
        Integer oldQ216 = this.q216;
        this.q216 = q216;
        changeSupport.firePropertyChange("Q216", oldQ216, q216);
    }

    public Integer getQ316() {
        return q316;
    }

    public void setQ316(Integer q316) {
        Integer oldQ316 = this.q316;
        this.q316 = q316;
        changeSupport.firePropertyChange("Q316", oldQ316, q316);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Crime)) {
            return false;
        }
        Crime other = (Crime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "assignment_5_project.Crime[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

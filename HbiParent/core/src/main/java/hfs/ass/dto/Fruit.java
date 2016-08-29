package hfs.ass.dto;

import com.hand.hap.core.annotation.MultiLanguage;
import com.hand.hap.core.annotation.MultiLanguageField;
import com.hand.hap.system.dto.BaseDTO;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by taotao.xu on 16/6/24.
 */
@MultiLanguage
@Table(name = "fruit_b")
public class Fruit  extends BaseDTO {
    
    /**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	@Id
    @Column
    @GeneratedValue
    private  Long fruitId;
    
    @Column
    @NotEmpty
    private String fruitName;
    
    @Column
    @NotEmpty
    private String fruitCode;
    
    @Column
    @MultiLanguageField
    private String fruitDescription;
    
    @Column
    @NotNull
    private Date startActiveDate;
    
    @Column
    @NotNull
    private Date endActiveDate;
    
	

	public Date getStartActiveDate() {
		return startActiveDate;
	}

	public void setStartActiveDate(Date startActiveDate) {
		this.startActiveDate = startActiveDate;
	}

	public Date getEndActiveDate() {
		return endActiveDate;
	}

	public void setEndActiveDate(Date endActiveDate) {
		this.endActiveDate = endActiveDate;
	}

	public String getFruitCode() {
		return fruitCode;
	}

	public void setFruitCode(String fruitCode) {
		this.fruitCode = fruitCode;
	}

	public Long getFruitId() {
		return fruitId;
	}

	public void setFruitId(Long fruitId) {
		this.fruitId = fruitId;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDescription() {
		return fruitDescription;
	}

	public void setFruitDescription(String fruitDescription) {
		this.fruitDescription = fruitDescription;
	}
    
}

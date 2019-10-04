package jdbcdemo4.entity;

import java.util.Date;

public class Pet {
	private int id;// 宠物id
	private int masterId;// 主人id
	private String name;// 昵称
	private int typeId;// 类型id
	private int health;// 健康值
	private int love;// 亲密度
	private Date adoptTime;// 领养时间
	private String status;// 状态
	
	//无参数的构造方法
	public Pet(){
		System.out.println("pet的缺省构造方法");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMasterId() {
		return masterId;
	}

	public void setMasterId(int masterId) {
		this.masterId = masterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		this.love = love;
	}

	public Date getAdoptTime() {
		return adoptTime;
	}

	public void setAdoptTime(Date adoptTime) {
		this.adoptTime = adoptTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

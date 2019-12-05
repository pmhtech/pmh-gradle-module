package net.pmhtech.monitor.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class LogMaster{
	private Integer programId;	// 프로그램 IDPRI
	private Integer platformType;	// 플랫폼 구분PRI
	private String platformUserId;	// 플랫폼 사용자ID
	private String title; //방송제목
	private String snapshotPath;	// 스냅샷경로
	private Integer viewCount;	// 시청자수
	private String createUserId;	// 생성자
	private Timestamp createDate;	// 생성시각
	private String createIp;	// 생성IP


	private LogMaster(){}

	public LogMaster(Integer platformType, String platformUserId, String title, String snapshotPath, Integer viewCount){
		this.platformType=platformType;
		this.platformUserId=platformUserId;
		this.title=title;
		this.snapshotPath=snapshotPath;
		this.viewCount=viewCount;
	}
}

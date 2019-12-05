package net.pmhtech.monitor.domain;

import lombok.Data;

@Data
public class LogMaster{
	private String programId;	// 프로그램 IDPRI
	private String logTime;	// 로그시각
	private String platformType;	// 플랫폼 구분PRI
	private String platformUserId;	// 플랫폼 사용자ID
	private String title; //방송제목
	private String snapshotPath;	// 스냅샷경로
	private String viewCount;	// 시청자수
	private String createUserId;	// 생성자
	private String createDate;	// 생성시각
	private String createIp;	// 생성IP


	private LogMaster(){}

	public LogMaster(String logTime, String platformType, String platformUserId, String title, String snapshotPath, String viewCount){
		this.logTime=logTime;
		this.platformType=platformType;
		this.platformUserId=platformUserId;
		this.title=title;
		this.snapshotPath=snapshotPath;
		this.viewCount=viewCount;
	}
}

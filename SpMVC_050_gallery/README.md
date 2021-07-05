# 파일 업로드할때
* 이미지 게시판

## 필요한 Dependency

	<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.10.0</version>
		</dependency>

	<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.4</version>
		</dependency>
		
## root-context.xml에 File Up 설정

* maxUploadPerFile : 파일 1개의 용량 제한
* maxUploadFile : 전체 파일 용량 제한, 다수의 파일을 올릴때
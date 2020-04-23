
![workflow_설계](https://user-images.githubusercontent.com/5702054/80049360-9c54ca80-854d-11ea-9359-08d0b9749347.PNG)

https://github.com/albe1022/msa_gateway
https://github.com/albe1022/msa_rawdata
https://github.com/albe1022/msa_workflow
https://github.com/albe1022/msa_preprocess
https://github.com/albe1022/msa_inference

MQ 기반 ML inference Workflow
데이터 저장, workflow 시작, 데이터 전처리, 데이터 inference 시나리오

1. inference 할 rawdata 저장
http 52.231.118.229:8080/rawDatas dataType=image

DataSaved 이벤트 발생

http 52.231.118.229:8080/rawDataLists
view 에서 확인 가능 (CQRS)

2. workflow 시작
http 52.231.118.229:8080/workflowHists rawDataId=1 dataType=image

Workflow Started, Data Preprocessed, Inference Run 이벤트 발생 (Saga)

- 써킷 브레이크
workflow와 preprocess 사이는 feign client로 req/res 통신함
workflow application.yml 에 hystrix, processeddata.java 에 임의 부하를 줘서 CB 구현

- Autoscale
오토스케일 적용함
![autoscale](https://user-images.githubusercontent.com/5702054/80049853-002bc300-854f-11ea-9f22-d63b203667be.PNG)

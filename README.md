# Kotlin + Spring Boot 샘플 프로젝트(by 현기님) 

## Docker설치
https://hub.docker.com/editions/community/docker-ce-desktop-mac
(개인계정가입 - Optional)

# 각 모듈 설명

## 비서버 모듈
| 모듈                      |             설명             |
|-------------------------|:--------------------------:|
| booklevel-domain-core   | persistence ( DB / Cache ) |
| booklevel-domain-model |   공통 Model ( Optional )    |
| booklevel-app-api      |          앱 제공 API          |

## 서버 모듈

- 내부망 연동 api는 http:// 선택 진행.
- 외부 노출 연동 api는 https:// 필수.

| 모듈                      |           설명           |       서버 |
|-------------------------|:----------------------:|---------:|
| booklevel-app-api      |      모바일앱웹 제공 API      |  http:// |
| booklevel-internal-api |    BOOKLEVEL API (Admin)     |  http:// |
| booklevel-external-api | BOOKLEVEL 내부 제공 API(Yanolja) |  http:// |
| booklevel-outbound-api |  BOOKLEVEL 외부 회사 제공 API(업체)  | https:// |
# 구현할 기능 목록
[x] 랜덤 번호 생성 및 저장 기능 
[x] 구입 금액 입력 기능 
[x] 구입 금액 입력값 검증 기능 
[x] 로또 발행 개수 계산 기능
[x] 로또 발행 기능 
[x] 발행한 로또 수량 및 번호 출력 기능 
[x] 당첨 번호 입력 기능 
[x] 당첨 번호 입력값 검증 기능 
[x] 번호 일치 여부 확인 및 당첨 여부 확인 기능 
[x] 당첨 내역 출력 기능 
[x] 수익률 계산 및 반올림 기능 
[x] 수익률 출력 기능 
[x] 예외 처리 및 에러 문구 출력 기능

# 구현할 클래스 목록
## WinningNumber - 당첨 번호
- compareWithLottoList() 당첨 번호와 로또 번호 비교

## Lotto - 로또 정보
- getNumbers() 로또 번호 조회

## FrontController - 프론트 컨트롤러
- playLotto() 로또 플레이

## LottoController - 로또 컨트롤러
- saveLotto() 로또 저장
- getPublishNum() 로또 발행량 계산
- publishLotto() 로또 티켓 발행
- getWinningNumber() 당첨 번호 및 보너스 번호 저장후 조회
- checkEarningRate() 수익률 조회

## LottoService - 로또 서비스
- saveLotto() 랜덤한 숫자 생성을 통한 Lotto 생성 및 저장
- savePublishNum() 로또 발행량 계산 및 저장
- publishLotto() 로또 티켓 발행
- saveWinningNumber() 당첨 번호 저장
- checkWinningNumber() 당점 정보 비교 및 결과 계산
- checkEarningRate() 수익률 조회

## LottoRepository - 로또 레포지토리
- saveLotto() Lotto 객체 저장
- saveWinningNumber() WinningNumber 객체 저장
- findAllLotto() 로또 전체 조회
- findWinningNumber() 당첨 번호 조회
- savePublishNumber() 발행량 저장
- findPublishNumber() 발행량 조회
- saveRewardAmount() 당첨금 저장
- findRewardAmount() 당첨금 조회

## InputManager - 입력 받기
- buyAmountInput() 구매 금액 입력
- winningNumberInput() 당첨 번호 입력
- bonusNumberInput() 보너스 번호 입력

## InputValidator - 입력 검증
- validateIsNumeric() 입력값 숫자인지 검증
- validateMultiplyOfThousand() 1000의 배수인지 검증
- validateIsListWithComma() 콤마로 구분된 숫자들의 나열인지 검증

## OutputManager - 출력하기
- printStartMessage() 로또 시작 메시지 출력
- printPublishNum() 로또 발행 개수 메시지 출력
- printLottoList() 발행한 로또 티켓 출력
- printCreateWinningNumber() 당첨 번호 입력 메시지 출력
- printCreateBonusNumber() 보너스 번호 입력 메시지 출력
- printResult() 결과 정보 출력
- printEarningRate() 수익률 출력
- printErrorMessage() 에러 메시지 출력

## ResultMap - 결과 종류 마다의 개수 저장
- getResultMap() 결과 관련 map 조회
- getRewardAmount() 최종 얻은 수익 계산

## RewardMoneyMap - 당첨금 관련 매핑 정보 저장
- getRewardMoney() 개수에 따른 RewardMoney 조회
- getMatchNum() RewardMoney에 따른 개수 조회

## OutputFormatter - 출력 String 포매팅
- formatResultString() 결과 string 포맷
- formatEarningRateString() 수익률 string 포맷
- formatPublishNum() 발행 개수 string 포맷

## ComponentFactory - 컴포넌트들의 생성

# Enum 목록
## LottoMessage - 로또 진행 메시지

## ErrorMessage - 에러 메시지

## LottoNumberRange - 로또 생성 범위

## RewardMoney - 당첨금 정보

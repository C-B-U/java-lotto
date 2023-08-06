# 구현할 기능 목록
1. 랜덤 번호 생성 및 저장 기능 
2. 구입 금액 입력 기능 
3. 구입 금액 입력값 검증 기능 
4. 로또 발행 개수 계산 기능
5. 로또 발행 기능 
6. 발행한 로또 수량 및 번호 출력 기능 
7. 당첨 번호 입력 기능 
8. 당첨 번호 입력값 검증 기능 
9. 번호 일치 여부 확인 및 당첨 여부 확인 기능 
10. 당첨 내역 출력 기능 
11. 수익률 계산 및 반올림 기능 
12. 수익률 출력 기능 
13. 예외 처리 및 에러 문구 출력 기능

# 구현할 클래스 목록
## LottoTicket - 발행한 로또 티켓

## WinningNumber - 당첨 번호

## FrontController - 프론트 컨트롤러
- playLotto() 로또 플레이

## LottoController - 로또 컨트롤러
- saveLotto() 로또 저장
- getPublishNum() 로또 발행량 계산
- publishLottoTickets() 로또 티켓 발행
- getWinningNumber() 당첨 번호 및 보너스 번호 저장후 조회

## LottoService - 로또 서비스
- saveLotto() 랜덤한 숫자 생성을 통한 Lotto 생성 및 저장
- getPublishNum() 로또 발행량 계산
- publishLottoTickets() 로또 티켓 발행
- saveWinningNumber() 당첨 번호 저장

## LottoRepository - 로또 레포지토리
- saveLotto() Lotto 객체 저장
- saveLottoTicket() LottoTicket 객체 저장
- saveWinningNumber() WinningNumber 객체 저장

## InputManager - 입력 받기
- buyAmountInput() 구매 금액 입력
- winningNumberInput() 당첨 번호 입력
- bonusNumberInput() 보너스 번호 입력

## InputValidator - 입력 검증
- validateIsNumeric() 입력값 숫자인지 검증
- validateMultiplyOfThousand() 1000의 배수인지 검증

## OutputManager - 출력하기
- printStartMessage() 로또 시작 메시지 출력
- printPublishNum() 로또 발행 개수 메시지 출력
- printLottoTickets() 발행한 로또 티켓 출력
- printCreateWinningNumber() 당첨 번호 입력 메시지 출력
- printCreateBonusNumber() 보너스 번호 입력 메시지 출력

## ComponentFactory - 컴포넌트들의 생성

# Enum 목록
## LottoMessage - 로또 진행 메시지

## ErrorMessage - 에러 메시지

## Number - 로또 생성 범위 및 로또 실행에 필요한 숫자
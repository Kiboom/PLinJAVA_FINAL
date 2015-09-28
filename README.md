# PLinJAVA_FINAL
PL in JAVA 기말 과제

#### 주제 : 스타벅스 직원을 몇 명까지 두었을 때 가장 이윤이 많이 남나!
- 스타벅스에 직원 몇 명을 두어야 이윤이 가장 많이 남을지 시뮬레이팅하는 프로그램입니다.
- 시뮬레이팅 사용방법은 아래 설명되어있습니다.

##### 1. 초기화 :
- EmployStrategy.properties로 고용할 인원수와 시급을 설정할 수 있습니다.
- PriceStrategy.properties로 커피 가격을 설정할 수 있습니다.
- Define 클래스의 INITIAL_CUSTOMER 상수로 '최초에 대기하는 손님의 수'를 설정할 수 있습니다.
- Define 클래스의 SIMULATING_TIME 상수로 '시뮬레이팅 진행 시간'을 설정합니다.
- 현실 세계의 1분은 10ms라고 셈칩니다. ex) 2400ms == 240분 == 4시간

##### 2. 손님 :
- 손님은 WaitingLine 객체에 줄서서 대기합니다.
- 20ms마다 한 명씩 손님이 늘어납니다.
- 자기 차례가 되면 카운터에서 놀고 있는 직원들에게 커피를 주문합니다. 직원들이 전부 일하고 있으면 대기합니다.
- 50ms마다 한 명씩 기다리다 지친 손님이 나갑니다. 즉, 마냥 직원을 적게만 둘 수는 없는 겁니다.

##### 3. 메뉴 :
- 커피 메뉴는 데코레이터 패턴으로 구현되어있습니다.
- 커피는 base coffee와 decorator로 나뉩니다.
- base coffee는 말그대로 베이스가 되는 커피로서, Americano와 Kenya가 있습니다.
- decorator는 base coffee를 꾸며주는 역할을 합니다. Latte와 Mocha가 있습니다.
- 손님이 주문할 커피는 랜덤으로 정해집니다. 즉, 1개 이상의 base coffee와 0개 이상의 decorator로 이루어집니다.
- decorator가 추가되면 가격과 제조시간 등의 정보가 base coffee에 더해집니다.

##### 4. 직원 :
- 직원의 종류는 Junior, Middle, Senior로 구분됩니다. Senior가 일을 제일 잘해서 시급도 높습니다.
- 모든 직원은 Worker 클래스를 상속합니다.
- 직원이 하는 일은 별 것 없습니다. 카운터에서 주문을 받아서 열심히 커피를 만들면 됩니다.
- 커피를 다 만들면 Sales.setTotalSales 메서드를 이용해 판매한 커피값을 장부에 기록합니다. 
- 시뮬레이터가 종료되면 Salary 클래스를 통해 임금을 정산합니다. 시뮬레이팅 시간과 직원들의 시급을 바탕으로 임금을 계산합니다.

##### 5. 종료 :
- 시뮬레이터가 끝나면 전체 판매금액과 직원 임금, 순이익 등을 계산해서 보여줍니다.
- 사용자는 순이익을 보고 직원들을 몇 명정도 배치해야 하는지 판단할 수 있습니다.


#### 구현하며 겪은 애로사항 :
- 별도의 쓰레드를 두어서 손님이 주기적으로 들어가고 나가는 상황을 구현했습니다. 그런데 이놈의 쓰레드가 한번 CPU를 점유하면 양보하지를 않네요ㅠ 커피는 안만들어지고 손님만 계속 늘어납니다ㅠ
- 손님들에게 순번을 부여하기 어렵습니다. 먼저 들어온 손님의 주문을 먼저 받게 하고 싶은데, 쓰레드에 우선순위를 부여하기 어렵습니다ㅠ

-- 제품 정보 테이블 products에서 id, name만 출력하기
SELECT id, name from products;
-- products에서 price, discount_price를 10개만 출력하기
SELECT price, discount_price 
	FROM products 
	LIMIT 10;
-- SQL문의 경우에는 순서가 매우 명확하게 정해져있는 편이기 때문에
-- 읽기는 쉽지만 익숙해지기 전까지 직접 작성하는 것이 까다로운 편

-- orderdetails의 모든 정보 표시하세요
SELECT * FROM Orderdetails;
-- 회원 정보 테이블 users에서 상위 7건만 표시하세요.(전부 다요)
SELECT * FROM users LIMIT 7;
-- orders에서 id, user_id, order_date 컬럼의 데이터를 모두 표시하세요.
SELECT id, user_id, order_date FROM orders;


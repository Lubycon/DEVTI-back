INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type) VALUES(now(), now(), "완전 현직 개발자 type", "나에게 딱 맞는\n개발자 직군을 찾아보세요", 'TYPE_COMMON_1');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type) VALUES(now(), now(), "개발자 준비 중 취업러 type", "지금 백엔드와 프론트엔드\n갈림길에 있나요?", 'TYPE_COMMON_2');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type) VALUES(now(), now(), "기업 성향을 알아보고 싶은 type", "나는 스타트업 성향일까\n대기업 성향일까?", 'TYPE_COMMON_3');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type) VALUES(now(), now(), "성향 테스트를 좋아하는 사람 type", "나도 개발자가 된다면?\n코딩지식없이 테스트하기!", 'TYPE_COMMON_4');
INSERT INTO bucket_test_type(created_at, updated_at, description, phrases, test_type) VALUES(now(), now(), "아이들은 위한 엄마들의 맘카페 type", "우리 아이의 코딩 잠재력을\n바로 확인하세요!", 'TYPE_MOM_CAFE_1');

INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '내가 개발한 초코파이과자가 반응이 좋다! 그 다음에 할 일은?', 'PRESET');
INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '큰 과제가 끝나고 시간이 생겼다. 내가 시간을 투자할 곳은?', 'PRESET');
INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '다양한 취미 vs 취미 없음', 'GAGE');
INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '단기간에 위험성이 높지만 큰 이득을 볼수있는 투자방식을 좋아한다.', 'GAGE');
INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '로마에가면 로마법을 따른다(text좋아보이게) vs 로마법따위 맘에 안들면 고쳐서 쓰자', 'GAGE');
INSERT INTO question (created_at, updated_at, title, answer_type) VALUES(now(), now(), '사용자가 무엇을 원하는지 확실하지 않은 기능을 개발했다. 가장 먼저 할것은?', 'PRESET');

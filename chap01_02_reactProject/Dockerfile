FROM node:lts-alpine
# alpine은 경량화된 버전, node.js 사용

WORKDIR /app 
# 컨테이너 내부에서 쓸 수 있는 임시 폴더 생성

COPY . ./
# 프로젝트 관련 파일 복제

RUN npm install
# react에서 가장 중요한 node_modules 실행

CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]
# npm run dev 대신에 컨테이너에 올라갈 때 실행시켜주는 명령어, 각 ,가 스페이스 바라고 생각하면 됨
# dev 까지는 vite관련 설정, 그 뒤에 -- 부터는 npm 관련 설정
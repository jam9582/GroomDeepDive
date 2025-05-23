import {useState} from "react";
function App() {
  const [num1, setNum1] = useState(0);
  const [num2, setNum2] = useState(0);
  const [result, setResult] = useState(0);
  const sendPlus = async () => {
    const response = 
    // docker image로 container 동작 시키기 전
    // await fetch(`http://localhost:7777/plus?num1=${num1}&num2=${num2}`);

    // 8055 컨테이너(8055:7777 로 되어 있는 백엔드 서버 컨테이너) 로 요청 시
    await fetch(`http://localhost:8055/plus?num1=${num1}&num2=${num2}`);

    const data = await response.json();
    console.log('data', data);

    setResult(data.sum);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h1>덧셈 기능 만들기</h1>
      <label>num1: </label>
      <input
        type="text"
        value={num1}
        onChange={e => setNum1(e.target.value)}
      />&nbsp;
      <label>num2: </label>
      <input
        type="text"
        value={num2}
        onChange={e => setNum2(e.target.value)}
      />&nbsp;
      <button onClick={sendPlus}>더하기</button>
      <hr />
      <p>{`${num1} + ${num2} = ${result}`}</p>
    </div>
  );
}
export default App
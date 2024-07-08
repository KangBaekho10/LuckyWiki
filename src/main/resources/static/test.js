import http from 'k6/http';
import { sleep } from 'k6';

const influxDBUrl = 'http://localhost:8086/';
const influxDBToken = 'KTaXgMfe9yBtcyfLLwH9k9az3McfhagfiyP0wtUB9W61h9MaU2fDfzKcy0r8ruVlB0DxVrC7DHy0HA03d0i0CQ';
const real7DBToken = '27tziKHxOJJe2_Bw7NgAHgZZp4rSwh6E5qX5SVmOryBKbAw7FEeTNFCwcOgPGTi_j3YIU84_Ne_rhGXMM6tWzw==';

export let options = {

    vus: 10, // 가상 사용자 수
    duration: "10s" , // 테스트 시간

    // stages: [
    //     { duration: '2s', target: 5 },
    //     { duration: '10s', target: 5 },
    //     { duration: '3s', target: 10 },
    //     { duration: '30s', target: 10 },
    //     { duration: '3s', target: 0 },
    // ],
    ext: {
        loadimpact: {
            projectID: 123456,
            name: "Sample Test Script"
        },
    },
};

export default function () {

    http.get('http://localhost/api/v1/today'); // 다른 http 메서드 사용 가능
    sleep(10);
}

// //POST
// export default function (){
//
//     const url = 'http://localhost/api/v1/wikis'; // 테스트 url 입력
//
//     let payloads = {
//         title : "title",
//         content : "content",
//         tags : "tags",
//     }
//
//     let params = {
//         headers: {
//             'Content-Type': 'application/json',
//         },
//     };
//     http.post(url,payloads, params)
//
//
// }
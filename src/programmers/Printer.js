function solution(priorities, location) {

    let lo = location;
    let count = 0;
    while(priorities.length > 0) {
        // 중요도가 높은 문서가 있는지 탐색
        let isMax = true;
        for(let i = 1; i < priorities.length; i++) {
            if(priorities[0] < priorities[i]) {
                priorities.push(priorities.shift())
                lo = lo - 1 == -1 ? priorities.length - 1 : lo - 1;
                isMax = false;
                break;
            }
        }

        if (isMax) {
            priorities.shift();
            count++;
            if (lo == 0)
                return count;
            else
                lo--;
        }
    }
}
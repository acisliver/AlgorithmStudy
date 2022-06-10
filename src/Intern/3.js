const DX = [0, 0, 1, -1];
const DY = [1, -1, 0, 0];
let answer;
let block;

function solution(board) {
    answer = 0;

    for (let i = 0; i < board.length; i++) {
        block = 0;
        const visited = new Array(board.length).fill(false).map(() => new Array(board.length).fill(false))
        for (let j = 0; j < board.length; j++) {
            if (!visited[i][j]) {
                visited[i][j] = true;
                block++;
            }
            dfs([i, j], visited, board)
        }
        answer = Math.max(answer, block);
    }

    for (let i = 0; i < board.length; i++) {
        block = 0;
        const visited = new Array(board.length).fill(false).map(() => new Array(board.length).fill(false))
        for (let j = 0; j < board.length; j++) {
            if (!visited[j][i]) {
                visited[j][i] = true;
                block++;
            }
            dfs([j, i], visited, board)
        }
        answer = Math.max(answer, block);
    }

    return answer;
}

function dfs(cur, visited, board) {

    for (let i = 0; i < 4; i++) {
        const next1 = cur[0] + DX[i];
        const next2 = cur[1] + DY[i];

        if (next1 < 0 || next2 < 0 || next1 > board.length - 1 || next2 > board.length - 1) continue;

        if (visited[next1][next2]) continue;

        if (board[cur[0]][cur[1]] !== board[next1][next2]) continue;

        visited[next1][next2] = true;
        block++;
        dfs([next1, next2], visited, board);
    }
}

console.log(solution(["ABBBBC", "AABAAC", "BCDDAC", "DCCDDE", "DCCEDE", "DDEEEB"]))
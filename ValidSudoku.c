/* Question 36: https://leetcode.com/problems/valid-sudoku/
   Approach: Use three arrays to track the numbers in each row, column, and 3x3 box.
   If a number is already present in any of these, return false.
*/
bool isValidSudoku(char** board, int boardSize, int* boardColSize) {
    int i,j,indr,indc,indb;
    int** rows=malloc(boardSize*sizeof(int*));
    int** cols=malloc(boardSize*sizeof(int*));
    int** boxes=malloc(boardSize*sizeof(int*));

    for(i=0;i<boardSize;i++)
    {
        rows[i]=calloc(boardSize+1,sizeof(int));
        cols[i]=calloc(boardSize+1,sizeof(int));
        boxes[i]=calloc(boardSize+1,sizeof(int));
    }

    for(i=0;i<boardSize;i++)
    {
        for(j=0;j<boardSize;j++)
        {
            if(isdigit(board[i][j]))
            {
                indr=board[i][j]-'0';
                if(rows[i][indr]) return false;
                rows[i][indr]=1;
            }
            if(isdigit(board[j][i]))
            {
                indc=board[j][i]-'0';
                if(cols[i][indc]) return false;
                cols[i][indc]=1;
            }

        }
    }
    int start=0,end=3,b=0,ins=0,ine=3;
    while(ine!=12)
    {
    start=0;
    end=3;
    while(end!=12)
    {
        for(i=start;i<end;i++)
        {
            for(j=ins;j<ine;j++)
            {
                if(isdigit(board[i][j]))
                {
                    indb=board[i][j]-'0';
                    if(boxes[b][indb]) return false;
                    boxes[b][indb]=1;
                }
            }
        }
        b+=1;
        start=end;
        end+=3;
    }
    ins=ine;
    ine+=3;
    }
    return true;
}
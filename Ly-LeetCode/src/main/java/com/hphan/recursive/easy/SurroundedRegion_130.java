package com.hphan.recursive.easy;

/**
 * Typical Count Island Problem
 * 
 * @author Ly
 *
 */
public class SurroundedRegion_130
{
    public void solve(char[][] board)
    {
	if (board.length < 2)
	    return;
	if (board[0].length < 2)
	    return;

	for (int i = 0; i < board[0].length; i++)
	{
	    if (board[0][i] == 'O')
		mark(board, 0, i);

	    if (board[board.length - 1][i] == 'O')
		mark(board, board.length - 1, i);
	}

	for (int i = 0; i < board.length; i++)
	{
	    if (board[i][0] == 'O')
		mark(board, i, 0);

	    if (board[i][board[0].length - 1] == 'O')
		mark(board, i, board[0].length - 1);
	}

	for (int i = 0; i < board.length; i++)
	{
	    for (int j = 0; j < board[0].length; j++)
	    {
		if (board[i][j] == 'O')
		    board[i][j] = 'X';
		if (board[i][j] == 'T')
		    board[i][j] = 'O';
	    }
	}
    }

    public void mark(char[][] board, int i, int j)
    {
	board[i][j] = 'T';

	if ((i < board.length - 1) && (board[i + 1][j] == 'O'))
	    mark(board, i + 1, j);
	if ((j < board[0].length - 1) && (board[i][j + 1] == 'O'))
	    mark(board, i, j + 1);
	if ((i > 0) && (board[i - 1][j] == 'O'))
	    mark(board, i - 1, j);
	if ((j > 0) && (board[i][j - 1] == 'O'))
	    mark(board, i, j - 1);
    }
}

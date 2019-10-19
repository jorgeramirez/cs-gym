"""
You are given a two-dimensional array (matrix) of potentially unequal height and width containing only 0s and 1s.
Each 0 represents land, and each 1 represents part of a river. A river consists of any number of 1s that are
either horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming
a river determine its size. Write a function that returns an array of the sizes of all rivers represented in the
input matrix. Note that these sizes do not need to be in any particular order.

Sample input:
[
    [1, 0, 0, 1, 0],
    [1, 0, 1, 0, 0],
    [0, 0, 1, 0, 1],
    [1, 0, 1, 0, 1],
    [1, 0, 1, 1, 0]
]

Sample output: [1, 2, 2, 2, 5]
"""

# Time: O(rc)
# Space: O(rc)


def river_sizes(matrix):
    n_rows = len(matrix)
    n_cols = len(matrix[0])
    tmp_matrix = [[-1] * n_cols for r in range(n_rows)]
    rivers = []

    for i in range(0, n_rows):
        for j in range(0, n_cols):
            left = j - 1
            top = i - 1

            if left >= 0 and top >= 0 and matrix[i][j] == 1\
                    and tmp_matrix[i][left] != tmp_matrix[top][j]\
                    and tmp_matrix[i][left] != -1\
                    and tmp_matrix[top][j] != -1:
                # we found two rivers with a common node, then we merge them and
                # unify the cells in the tmp_matrix
                r1_idx = tmp_matrix[i][left]
                r2_idx = tmp_matrix[top][j]
                r1 = rivers[r1_idx]
                r2 = rivers[r2_idx]
                rivers[r1_idx] = r1 + r2
                rivers[r2_idx] = -1

                for cell in rivers[r1_idx]:
                    tmp_matrix[cell[0]][cell[1]] = r1_idx
                tmp_matrix[i][j] = r1_idx                    
                rivers[r1_idx].append((i, j))
            elif left >= 0 and matrix[i][left] + matrix[i][j] == 2:
                tmp_matrix[i][j] = tmp_matrix[i][left]
                rivers[tmp_matrix[i][j]].append((i, j))
            elif top >= 0 and matrix[top][j] + matrix[i][j] == 2:
                tmp_matrix[i][j] = tmp_matrix[top][j]
                rivers[tmp_matrix[i][j]].append((i, j))
            elif matrix[i][j] == 1:
                tmp_matrix[i][j] = len(rivers)
                rivers.append([(i, j)])

    for r in matrix:
        print(r)
    return [len(r) for r in rivers if r != -1]


if __name__ == "__main__":
    print("\n", river_sizes([
        [1, 0, 0, 1, 0],
        [1, 0, 1, 0, 0],
        [0, 0, 1, 0, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 0]
    ]))

    print("\n", river_sizes([
        [1, 1, 1, 1, 1],
        [0, 0, 0, 0, 1],
        [1, 1, 1, 1, 1],
    ]))

    print("\n", river_sizes([
        [1, 1, 1, 1, 1],
        [0, 0, 1, 0, 0],
        [0, 0, 1, 0, 0],
        [1, 1, 1, 1, 1],
    ]))

    print("\n", river_sizes([
        [1, 1, 1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1, 1, 1],
        [1, 1, 1, 1, 1, 0, 1]
    ]))

    print("\n", river_sizes([
        [1]
    ]))

    print("\n", river_sizes([
        [1, 1, 0, 0, 0],
        [0, 1, 0, 0, 0],
        [0, 1, 1, 1, 1],
    ]))

    print("\n", river_sizes([
        []
    ]))

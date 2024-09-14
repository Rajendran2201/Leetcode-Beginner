class Solution:
    def findSafeWalk(self, grid: List[List[int]], health: int) -> bool:
        """
        :type grid: List[List[int]]
        :type health: int
        :rtype: bool
        """
        m, n = len(grid), len(grid[0])
        if grid[0][0] == 1:
            health -= 1
            
        if health <= 0:
            return False
        
        # Directions for up, down, left, right movements
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        queue = deque([(0, 0, health)])  # (row, col, remaining_health)
        visited = set((0, 0, health))  # Track visited states

        while queue:
            x, y, current_health = queue.popleft()

            # If we reached the bottom-right corner
            if x == m - 1 and y == n - 1:
                return True
            
            for dx, dy in directions:
                nx, ny = x + dx, y + dy

                if 0 <= nx < m and 0 <= ny < n:  # Check bounds
                    new_health = current_health - grid[nx][ny]  # Deduct health for unsafe cells

                    # Check if we can move to this cell with remaining health
                    if new_health > 0 and (nx, ny, new_health) not in visited:
                        visited.add((nx, ny, new_health))
                        queue.append((nx, ny, new_health))
        
        return False
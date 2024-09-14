SELECT u.name, sum(amount) as balance
FROM Users u
JOIN Transactions t
ON u.account = t.account
GROUP BY t.account 
HAVING sum(amount) > 10000;
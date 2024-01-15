n = tonumber(io.read())
next_token = string.gmatch(io.read(), "[^%s]+")
res = 0
for i=0,n-1 do
    t = tonumber(next_token())
    if i == 0 then
        res = t
    end
    if math.abs(t) < math.abs(res) then
        res = t
    end
    if math.abs(t) == math.abs(res) then
        res = math.max(res, t)
    end
end
print(res)

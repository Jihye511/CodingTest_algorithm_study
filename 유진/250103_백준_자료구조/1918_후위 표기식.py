arr=input()
ops=[]
ans=''

for i in arr:
    if i.isalpha():
        ans+=i

    elif i=='(':
        ops.append(i)

    elif i==')':
        while ops and ops[-1]!='(':
            ans+=ops.pop()
        ops.pop()

    elif i=='+' or i=='-':
        while ops and ops[-1]!='(':
            ans+=ops.pop()
        ops.append(i)

    elif i=='*' or i=='/':
        while ops and (ops[-1]=='*' or ops[-1]=='/'):
            ans+=ops.pop()

        ops.append(i)

while ops:
    ans+=ops.pop()

print(ans)
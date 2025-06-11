class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        for i in range(len(s)):
            if s[i]=='(' or s[i]=='{' or s[i]=='[':
                stack.append(s[i])
            else:
                if not stack:
                    return False
                x=stack.pop()
                if((s[i]==')' and x=='(') or (s[i]=='}' and x=='{') or (s[i]==']' and x=='[')):
                    continue
                else:
                    return False
        if len(stack)==0:
            return True
        else:
            return False
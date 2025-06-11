class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapp={}
        for i in range(len(nums)):
            ele=nums[i]
            req=target-nums[i]
            if req in mapp:
                return i,mapp[req]
            mapp[ele]=i
        return -1,-1


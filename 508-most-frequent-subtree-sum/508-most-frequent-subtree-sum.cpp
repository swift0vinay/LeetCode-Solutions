/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    map<int,int> m;
public:
    vector<int> findFrequentTreeSum(TreeNode* root) {
        dfs(root);
        vector<int> ans;
        int maxValue=-1;
        for(auto i=m.begin();i!=m.end();i++){
            maxValue=max(maxValue,i->second);
        }
        for(auto i=m.begin();i!=m.end();i++){
            if(i->second==maxValue)
                ans.push_back(i->first);
        }
        return ans;
    }
    int dfs(TreeNode* root){
        if(root==NULL)
            return 0;
        int left=dfs(root->left);
        int right=dfs(root->right);
        int curr=left+right+root->val;
        m[curr]++;
        return curr;
    }
};
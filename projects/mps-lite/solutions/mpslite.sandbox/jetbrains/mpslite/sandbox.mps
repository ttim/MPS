<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mpslite.sandbox">
  <language namespace="jetbrains.mps.nanoj" />
  <maxImportIndex value="1" />
  <node type="jetbrains.mps.nanoj.ClassConcept" id="1182965040933">
    <property name="name" value="ABCDEF" />
    <node role="method" type="jetbrains.mps.nanoj.InstanceMethod" id="1182965183761">
      <property name="name" value="abcdef" />
      <node role="type" type="jetbrains.mps.nanoj.ClassifierType" id="1182968136618">
        <link role="classifier" targetNodeId="1182965040933" resolveInfo="ABCDEF" />
      </node>
      <node role="body" type="jetbrains.mps.nanoj.StatementList" id="1182965191301">
        <node role="statement" type="jetbrains.mps.nanoj.IfStatement" id="1182966479686">
          <node role="condition" type="jetbrains.mps.nanoj.PlusExpression" id="1183022931763">
            <node role="right" type="jetbrains.mps.nanoj.PlusExpression" id="1183022934595">
              <node role="right" type="jetbrains.mps.nanoj.InstanceMethodCallExpression" id="1183022940583">
                <link role="method" targetNodeId="1182968897745" resolveInfo="Name" />
                <node role="instance" type="jetbrains.mps.nanoj.NumberExpression" id="1183022938645">
                  <property name="number" value="23" />
                </node>
              </node>
              <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183022932625">
                <property name="number" value="239" />
              </node>
            </node>
            <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183019747573">
              <property name="number" value="3" />
            </node>
          </node>
          <node role="body" type="jetbrains.mps.nanoj.StatementList" id="1183027517453" />
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.nanoj.InstanceMethod" id="1182968897745">
      <property name="name" value="Name" />
      <node role="type" type="jetbrains.mps.nanoj.ClassifierType" id="1183028558662">
        <link role="classifier" targetNodeId="1183028555504" resolveInfo="ZZZ" />
      </node>
      <node role="body" type="jetbrains.mps.nanoj.StatementList" id="1182968897747">
        <node role="statement" type="jetbrains.mps.nanoj.IfStatement" id="1182968906267">
          <node role="condition" type="jetbrains.mps.nanoj.InstanceMethodCallExpression" id="1182969814595">
            <link role="method" targetNodeId="1182968897745" resolveInfo="Name" />
            <node role="instance" type="jetbrains.mps.nanoj.InstanceMethodCallExpression" id="1182969823081">
              <link role="method" targetNodeId="1182968897745" resolveInfo="Name" />
              <node role="instance" type="jetbrains.mps.nanoj.EqualsExpression" id="1183028566303">
                <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183028569353">
                  <property name="number" value="239" />
                </node>
                <node role="right" type="jetbrains.mps.nanoj.PlusExpression" id="1183028574293">
                  <node role="right" type="jetbrains.mps.nanoj.NumberExpression" id="1183028576889">
                    <property name="number" value="21" />
                  </node>
                  <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183028572932">
                    <property name="number" value="23" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="body" type="jetbrains.mps.nanoj.StatementList" id="1182968906269">
            <node role="statement" type="jetbrains.mps.nanoj.IfStatement" id="1183019252117">
              <node role="body" type="jetbrains.mps.nanoj.StatementList" id="1183019252119">
                <node role="statement" type="jetbrains.mps.nanoj.LocalVariableDeclarationStatement" id="1183028052242">
                  <node role="declaration" type="jetbrains.mps.nanoj.LocalVariableDeclaration" id="1183028052243">
                    <property name="name" value="abc" />
                    <node role="type" type="jetbrains.mps.nanoj.ByteType" id="1183028059231" />
                    <node role="initializer" type="jetbrains.mps.nanoj.PlusExpression" id="1183028063936">
                      <node role="right" type="jetbrains.mps.nanoj.NumberExpression" id="1183028066939">
                        <property name="number" value="21" />
                      </node>
                      <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183028062748">
                        <property name="number" value="23" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.nanoj.PlusExpression" id="1183027486331">
                <node role="right" type="jetbrains.mps.nanoj.PlusExpression" id="1183027489054">
                  <node role="right" type="jetbrains.mps.nanoj.NumberExpression" id="1183027491979">
                    <property name="number" value="23" />
                  </node>
                  <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183027487287">
                    <property name="number" value="239" />
                  </node>
                </node>
                <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183019590520">
                  <property name="number" value="23" />
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.nanoj.LocalVariableDeclarationStatement" id="1183029030712">
              <node role="declaration" type="jetbrains.mps.nanoj.LocalVariableDeclaration" id="1183029030713">
                <property name="name" value="abcdef" />
                <node role="type" type="jetbrains.mps.nanoj.ByteType" id="1183029033638" />
                <node role="initializer" type="jetbrains.mps.nanoj.PlusExpression" id="1183029038593">
                  <node role="right" type="jetbrains.mps.nanoj.PlusExpression" id="1183029042222">
                    <node role="right" type="jetbrains.mps.nanoj.PlusExpression" id="1183029045132">
                      <node role="right" type="jetbrains.mps.nanoj.NumberExpression" id="1183029046182">
                        <property name="number" value="239" />
                      </node>
                      <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183029043335">
                        <property name="number" value="23" />
                      </node>
                    </node>
                    <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183029040815">
                      <property name="number" value="23" />
                    </node>
                  </node>
                  <node role="left" type="jetbrains.mps.nanoj.NumberExpression" id="1183029037373">
                    <property name="number" value="23" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.nanoj.ClassConcept" id="1183028555504">
    <property name="name" value="ZZZ" />
  </node>
</model>


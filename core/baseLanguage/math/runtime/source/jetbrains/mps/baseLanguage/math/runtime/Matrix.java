/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.baseLanguage.math.runtime;

import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes._return_P1_E0;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes._return_P2_E0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * Created by IntelliJ IDEA.
 * User: Sergey.Sinchuk
 * Date: Jun 13, 2009
 * Time: 5:09:20 PM
 * To change this template use File | Settings | File Templates.
 */

public class Matrix<T> {

  static public final MatrixScalarOperations<Byte> soByte = new MatrixScalarOperations<Byte>() {
    public Byte cast(Object o) {
      if (o instanceof Byte) return ((Byte) o);
      if (o instanceof Number) return ((Number) o).byteValue();
      throw new ClassCastException();
    }

    public Byte add(Object o1, Object o2) {
      return (byte) (cast(o1) + cast(o2));
    }

    public Byte mul(Object i1, Object o2) {
      return (byte) (cast(i1) * cast(o2));
    }

    public Byte neg(Object i) {
      return (byte) -cast(i);
    }

    public Byte inv(Object d) {
      throw new ArithmeticException();
    }

    public Byte conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<Short> soShort = new MatrixScalarOperations<Short>() {
    public Short cast(Object o) {
      if (o instanceof Short) return ((Short) o);
      if (o instanceof Number) return ((Number) o).shortValue();
      throw new ClassCastException();
    }

    public Short add(Object o1, Object o2) {
      return (short) (cast(o1) + cast(o2));
    }

    public Short mul(Object i1, Object o2) {
      return (short) (cast(i1) * cast(o2));
    }

    public Short neg(Object i) {
      return (short) -cast(i);
    }

    public Short inv(Object d) {
      throw new ArithmeticException();
    }

    public Short conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<Integer> soInt = new MatrixScalarOperations<Integer>() {
    public Integer cast(Object o) {
      if (o instanceof Integer) return (Integer) o;
      if (o instanceof Number) return ((Number) o).intValue();
      throw new ClassCastException();
    }

    public Integer add(Object o1, Object o2) {
      return cast(o1) + cast(o2);
    }

    public Integer mul(Object i1, Object o2) {
      return cast(i1) * cast(o2);
    }

    public Integer neg(Object i) {
      return -cast(i);
    }

    public Integer inv(Object d) {
      throw new ArithmeticException();
    }

    public Integer conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<Long> soLong = new MatrixScalarOperations<Long>() {
    public Long cast(Object o) {
      if (o instanceof Long) return ((Long) o);
      if (o instanceof Number) return ((Number) o).longValue();
      throw new ClassCastException();
    }

    public Long add(Object o1, Object o2) {
      return cast(o1) + cast(o2);
    }

    public Long mul(Object i1, Object o2) {
      return cast(i1) * cast(o2);
    }

    public Long neg(Object i) {
      return -cast(i);
    }

    public Long inv(Object d) {
      throw new ArithmeticException();
    }

    public Long conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<Float> soFloat = new MatrixScalarOperations<Float>() {
    public Float cast(Object o) {
      if (o instanceof Float) return ((Float) o);
      if (o instanceof Number) return ((Number) o).floatValue();
      throw new ClassCastException();
    }

    public Float add(Object o1, Object o2) {
      return cast(o1) + cast(o2);
    }

    public Float mul(Object i1, Object o2) {
      return cast(i1) * cast(o2);
    }

    public Float neg(Object i) {
      return -cast(i);
    }

    public Float inv(Object d) {
      return (float) (1.0 / cast(d));
    }

    public Float conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<Double> soDouble = new MatrixScalarOperations<Double>() {
    public Double cast(Object o) {
      if (o instanceof Double) return ((Double) o);
      if (o instanceof Number) return ((Number) o).doubleValue();
      throw new ClassCastException();
    }

    public Double add(Object o1, Object o2) {
      return cast(o1) + cast(o2);
    }

    public Double mul(Object i1, Object o2) {
      return cast(i1) * cast(o2);
    }

    public Double neg(Object i) {
      return -cast(i);
    }

    public Double inv(Object d) {
      return 1.0 / cast(d);
    }

    public Double conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return Math.abs(cast(o));
    }
  };
  static public final MatrixScalarOperations<BigInteger> soBigInteger = new MatrixScalarOperations<BigInteger>() {
    public BigInteger cast(Object o) {
      if (o instanceof BigInteger) return (BigInteger) o;
      // should be reimplemented
      if (o instanceof Number) return BigInteger.valueOf(((Number) o).longValue());
      throw new ClassCastException();
    }

    public BigInteger add(Object o1, Object o2) {
      return cast(o1).add(cast(o2));
    }

    public BigInteger mul(Object i1, Object o2) {
      return cast(i1).multiply(cast(o2));
    }

    public BigInteger neg(Object i) {
      return cast(i).negate();
    }

    public BigInteger inv(Object d) {
      throw new ArithmeticException();
    }

    public BigInteger conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return cast(o).abs();
    }
  };
  static public final MatrixScalarOperations<BigDecimal> soBigDecimal = new MatrixScalarOperations<BigDecimal>() {
    public BigDecimal cast(Object o) {
      if (o instanceof BigDecimal) return (BigDecimal) o;
      if (o instanceof BigInteger) return new BigDecimal((BigInteger) o);
      if (o instanceof Number) return BigDecimal.valueOf(((Number) o).doubleValue());
      throw new ClassCastException();
    }

    public BigDecimal add(Object o1, Object o2) {
      return cast(o1).add(cast(o2));
    }

    public BigDecimal mul(Object i1, Object o2) {
      return cast(i1).multiply(cast(o2));
    }

    public BigDecimal neg(Object i) {
      return cast(i).negate();
    }

    public BigDecimal inv(Object d) {
      return BigDecimal.valueOf(1.0).divide(cast(d));
    }

    public BigDecimal conj(Object o) {
      return cast(o);
    }

    public Object abs(Object o) {
      return cast(o).abs();
    }
  };
  static public final MatrixScalarOperations<Complex> soComplex = new MatrixScalarOperations<Complex>() {
    public Complex cast(Object o) {
      if (o instanceof Complex) return (Complex) o;
      if (o instanceof Number) return new Complex(((Number) o).doubleValue(), 0);
      throw new ClassCastException();
    }

    public Complex add(Object o1, Object o2) {
      return cast(o1).add(cast(o2));
    }

    public Complex mul(Object i1, Object o2) {
      return cast(i1).mul(cast(o2));
    }

    public Complex neg(Object i) {
      return Complex.ZERO.sub(cast(i));
    }

    public Complex inv(Object d) {
      return cast(d).inv();
    }

    public Complex conj(Object o) {
      return cast(o).conj();
    }

    public Object abs(Object o) {
      return cast(o).abs();
    }
  };
  static public final MatrixScalarOperations<BigComplex> soBigComplex = new MatrixScalarOperations<BigComplex>() {
    public BigComplex cast(Object o) {
      if (o instanceof BigComplex) return (BigComplex) o;
      if (o instanceof Complex) return new BigComplex((Complex) o);
      if (o instanceof BigInteger) return new BigComplex(new BigDecimal((BigInteger) o), BigDecimal.ZERO);
      if (o instanceof BigDecimal) return new BigComplex(((BigDecimal) o), BigDecimal.ZERO);
      if (o instanceof Number) return new BigComplex(((Number) o).doubleValue(), 0);
      throw new ClassCastException();
    }

    public BigComplex add(Object o1, Object o2) {
      return cast(o1).add(cast(o2));
    }

    public BigComplex mul(Object i1, Object o2) {
      return cast(i1).mul(cast(o2));
    }

    public BigComplex neg(Object i) {
      BigComplex c = cast(i);
      return new BigComplex(c.re().negate(), c.im().negate());
    }

    public BigComplex inv(Object d) {
      return cast(d).inv();
    }

    public BigComplex conj(Object o) {
      return cast(o).conj();
    }

    public Object abs(Object o) {
      return cast(o).abs(MathContext.DECIMAL128);
    }
  };

  static public final _return_P2_E0 zeroFunc = new _return_P2_E0<Integer, Object, Object>() {
    public Integer invoke(Object o, Object o2) {
      return (int) 0;
    }
  };
  static public final _return_P2_E0 deltaFunc = new _return_P2_E0<Integer, Integer, Integer>() {
    public Integer invoke(Integer o, Integer o2) {
      return o.equals(o2) ? 1 : 0;
    }
  };

  private Object[][] myCarrier = null;
  private int myRows = 0;
  private int myColumns = 0;
  private MatrixScalarOperations myOperations = null;

  public Matrix(Matrix m, _return_P1_E0<T, Object> f, MatrixScalarOperations operations) {
    myRows = m.myRows;
    myColumns = m.myColumns;
    this.myCarrier = new Object[myRows][myColumns];
    for (int i = 0; i < myRows; i++) for (int j = 0; j < myColumns; j++) myCarrier[i][j] = f.invoke(m.get(i, j));
    this.myOperations = operations;
  }

  public Matrix(boolean c, MatrixScalarOperations operations, Object... items) {
    //c true means vertical glue / false means horizontal glue
    if (items.length == 0) return;
    this.myOperations = operations;
    if (items[0] instanceof Matrix) {
      Matrix m = (Matrix) items[0];
      myRows = m.rowsCount();
      myColumns = m.columnsCount();
    } else {
      myRows = 1;
      myColumns = 1;
    }
    if (c) {
      for (int i = 1; i < items.length; i++) {
        if (items[i] instanceof Matrix) {
          Matrix m = (Matrix) items[i];
          if (myColumns != m.myColumns) throw new IllegalArgumentException();
          myRows += m.myRows;
        } else {
          if (myColumns != 1) throw new IllegalArgumentException();
          myRows++;
        }
      }
      myCarrier = new Object[myRows][myColumns];
      int rp = 0;
      for (Object item : items) {
        if (item instanceof Matrix) {
          for (Object[] row : ((Matrix) item).myCarrier) {
            System.arraycopy(row, 0, myCarrier[rp], 0, myColumns);
            rp++;
          }
        } else {
          myCarrier[rp][0] = item;
          rp++;
        }
      }
    } else {
      for (int i = 1; i < items.length; i++) {
        if (items[i] instanceof Matrix) {
          Matrix m = (Matrix) items[i];
          if (myRows != m.myRows) throw new IllegalArgumentException();
          myColumns += m.myColumns;
        } else {
          if (myRows != 1) throw new IllegalArgumentException();
          myColumns++;
        }
      }
      myCarrier = new Object[myRows][myColumns];

      for (int r = 0; r < myRows; r++) {
        int rc = 0;
        for (Object item : items) {
          if (item instanceof Matrix) {
            System.arraycopy(((Matrix) item).myCarrier[r], 0, myCarrier[r], rc, ((Matrix) item).myColumns);
            rc += ((Matrix) item).myColumns;
          } else {
            myCarrier[0][rc] = item;
            rc++;
          }
        }
      }
    }
  }

  public Matrix(T[][] data, MatrixScalarOperations operations) {
    myRows = data.length;
    myColumns = data[0].length;
    this.myOperations = operations;
    for (int i = 1; i < myRows; i++) if (myColumns != data[i].length) throw new IllegalArgumentException();
    myCarrier = new Object[myRows][myColumns];
    for (int i = 0; i < myRows; i++)
      System.arraycopy(data[i], 0, myCarrier[i], 0, myColumns);
  }

  public Matrix(Matrix m1, Matrix m2, MatrixOperation action, MatrixScalarOperations oper) {
    this.myOperations = oper;
    if (m1 == null || m2 == null) {
      if (m1 == null && m2 == null) throw new IllegalArgumentException();
      Matrix r = m1 == null ? m2 : m1;
      myRows = r.myRows;
      myColumns = r.myColumns;
      myCarrier = new Object[myRows][myColumns];
      for (int i = 0; i < myRows; i++) System.arraycopy(r.myCarrier[i], 0, myCarrier[i], 0, myColumns);
      return;
    }
    if (action == MatrixOperation.MatrixAdd) {
      myRows = m1.myRows;
      myColumns = m1.myColumns;

      if (m1.myColumns != m2.myColumns || m1.myRows != m2.myRows) throw new IllegalArgumentException();
      this.myCarrier = new Object[myRows][myColumns];

      for (int i = 0; i < myRows; i++)
        for (int j = 0; j < myColumns; j++) myCarrier[i][j] = oper.add(m1.get(i, j), m2.get(i, j));
    } else if (action == MatrixOperation.MatrixSub) {
      myRows = m1.myRows;
      myColumns = m1.myColumns;
      if (m1.myColumns != m2.myColumns || m1.myRows != m2.myRows) throw new IllegalArgumentException();
      this.myCarrier = new Object[myRows][myColumns];

      for (int i = 0; i < myRows; i++)
        for (int j = 0; j < myColumns; j++) myCarrier[i][j] = oper.add(m1.get(i, j), oper.neg(m2.get(i, j)));

    } else if (action == MatrixOperation.MatrixMul) {
      if (m1.columnsCount() != m2.rowsCount()) throw new IndexOutOfBoundsException();
      myRows = m1.rowsCount();
      myColumns = m2.columnsCount();
      this.myCarrier = new Object[myRows][myColumns];
      Object zero = oper.cast((short) 0);
      for (int i = 0; i < myRows; i++)
        for (int j = 0; j < myColumns; j++) {
          Object result = zero;
          for (int k = 0; k < m1.columnsCount(); k++)
            result = oper.add(result, oper.mul(oper.cast(m1.get(i, k)), oper.cast(m2.get(k, j))));
          myCarrier[i][j] = result;
        }
    }
  }

  public Matrix(Matrix m1, Object m2, MatrixScalarOperations oper, boolean invert) {
    myRows = m1.myRows;
    myColumns = m1.myColumns;
    this.myOperations = oper;
    this.myCarrier = new Object[myRows][myColumns];

    Object m2c;

    if (invert) m2c = oper.inv(m2);
    else m2c = oper.cast(m2);

    for (int i = 0; i < myRows; i++)
      for (int j = 0; j < myColumns; j++) myCarrier[i][j] = oper.mul(m1.get(i, j), m2c);

  }

  public Matrix(Matrix m, MatrixScalarOperations oper) {
    myRows = m.myRows;
    myColumns = m.myColumns;
    this.myOperations = oper;
    this.myCarrier = new Object[myRows][myColumns];
    for (int i = 0; i < myRows; i++)
      for (int j = 0; j < myColumns; j++) {
        myCarrier[i][j] = oper.cast(m.get(i, j));
      }
  }

  public Matrix(int r, int c, _return_P2_E0<T, Integer, Integer> f, MatrixScalarOperations oper) {
    myRows = r;
    myColumns = c;
    myOperations = oper;
    this.myCarrier = new Object[myRows][myColumns];
    for (int i = 0; i < myRows; i++)
      for (int j = 0; j < myColumns; j++) myCarrier[i][j] = oper.cast(f.invoke(i, j));
  }

  public Matrix(int n, _return_P2_E0<T, Integer, Integer> f, MatrixScalarOperations oper) {
    myRows = n;
    myColumns = n;
    myOperations = oper;
    this.myCarrier = new Object[myRows][myColumns];
    for (int i = 0; i < myRows; i++)
      for (int j = 0; j < myColumns; j++) myCarrier[i][j] = oper.cast(f.invoke(i, j));
  }

  public synchronized T get(int i, int j) {
    if (i < 0 || i > myRows || j < 0 || j > myColumns) throw new IndexOutOfBoundsException();
    return (T) this.myCarrier[i][j];
  }

  public synchronized Matrix<T> getRow(final int i) {
    if (i < 0 || i > myRows) throw new IndexOutOfBoundsException();
    return new Matrix(myColumns, 1, new _return_P2_E0<T, Integer, Integer>() {
      public T invoke(Integer p1, Integer p2) {
        return (T) myCarrier[i][p1];
      }
    }, myOperations);
  }

  public synchronized void setRow(final int i, Matrix vector) {
    if (vector.myColumns != 1 || vector.myRows != myColumns || i < 0 | i >= myRows)
      throw new IndexOutOfBoundsException();
    for (int j = 0; j < vector.myRows; j++) myCarrier[i][j] = vector.myCarrier[j][0];
  }

  public synchronized void setCol(final int i, Matrix vector) {
    if (vector.myColumns != 1 || vector.myRows != myRows || i < 0 | i >= myColumns)
      throw new IndexOutOfBoundsException();
    for (int j = 0; j < vector.myRows; j++) myCarrier[j][i] = vector.myCarrier[j][0];
  }

  public synchronized Matrix<T> getCol(final int i) {
    if (i < 0 || i > myColumns) throw new IndexOutOfBoundsException();
    return new Matrix(myRows, 1, new _return_P2_E0<T, Integer, Integer>() {
      public T invoke(Integer p1, Integer p2) {
        return (T) myCarrier[p1][i];
      }
    }, myOperations);
  }

  public synchronized int rowsCount() {
    return myRows;
  }

  public synchronized int columnsCount() {
    return myColumns;
  }

  public synchronized String toString() {
    String result = "";
    for (int i = 0; i < myRows; i++) {
      for (int j = 0; j < myColumns; j++) {
        result += myCarrier[i][j].toString();
        if (j < myColumns) result += ' ';
      }
      if (i < myRows - 1) result += '\n';
    }
    return result;
  }

  public synchronized void set(int i, int j, Object v) {
    myCarrier[i][j] = v;
  }

  public synchronized Matrix<T> transpose() {
    return new Matrix(myColumns, myRows, new _return_P2_E0() {
      public Object invoke(Object o, Object o1) {
        return myCarrier[(Integer) o1][(Integer) o];
      }
    }, myOperations);
  }

  public synchronized Matrix<T> conjugate() {
    return new Matrix(myColumns, myRows, new _return_P2_E0() {
      public Object invoke(Object o, Object o1) {
        return myOperations.conj(myCarrier[(Integer) o1][(Integer) o]);
      }
    }, myOperations);
  }

  public synchronized void addRow(int source, int dest, Object scalar) {
    if (source < 0 || dest < 0 || source >= myRows || dest >= myRows) throw new IndexOutOfBoundsException();
    for (int i = 0; i < myColumns; i++)
      myCarrier[dest][i] = myOperations.add(myCarrier[dest][i], myOperations.mul(scalar, myCarrier[source][i]));
  }

  public synchronized Matrix UTform(Matrix<T> aux, MatrixScalarOperations oper) {
    if (aux != null && aux.myRows != this.myRows) throw new IndexOutOfBoundsException();
    Object zero = oper.cast(0);
    Object unit = oper.cast(1);
    Matrix result = new Matrix(myCarrier, oper);
    for (int i = 0; i < myColumns; i++) {
      if ((result.get(i, i).equals(zero))) {
        boolean flag = false;
        for (int j = i + 1; j < myRows; j++) {
          if (!(result.get(j, i).equals(zero))) {
            if (aux != null) aux.addRow(j, i, unit);
            result.addRow(j, i, unit);
            flag = true;
            break;
          }
        }
        if (!flag) throw new ArithmeticException();
      }
      Object o = oper.inv(result.get(i, i));
      for (int j = i + 1; j < myRows; j++) {
        Object c = oper.neg(oper.mul(result.get(j, i), o));
        if (aux != null) aux.addRow(i, j, c);
        result.addRow(i, j, c);
      }
    }
    return result;
  }

  private T _det() {
    if (myRows != myColumns) throw new IndexOutOfBoundsException();
    Matrix m = UTform(null, myOperations);
    Object result = myOperations.cast(1);
    for (int i = 0; i < myRows; i++) result = myOperations.mul(result, m.get(i, i));
    return (T) result;
  }

  public synchronized T det() {
    if (myRows > 0 && myColumns > 0) {
      Object o = myCarrier[0][0];
      if (o instanceof Byte || o instanceof Short || o instanceof Long || o instanceof Integer) {
        Matrix<Double> d = new Matrix<Double>(this, soDouble);
        return (T) myOperations.cast(d._det());
      } else if (o instanceof BigInteger) {
        Matrix<BigDecimal> bd = new Matrix<BigDecimal>(this, new BigDecimalScalarOperations(MathContext.DECIMAL128));
        return (T) myOperations.cast(bd._det());
      } else {
        return this._det();
      }
    } else return null;
  }

  public synchronized Matrix linearsolve(Matrix rightSide, MatrixScalarOperations oper) {
    Matrix rS = new Matrix(rightSide, oper);
    if (rS.myColumns != 1 || myRows != myColumns) throw new IllegalArgumentException();
    Matrix ut = this.UTform(rS, oper);
    Object[][] obj = new Object[myRows][1];
    for (int i = myRows - 1; i >= 0; i--) {
      Object c = rS.get(i, 0);
      for (int j = i + 1; j < myRows; j++) c = oper.add(c, oper.neg(oper.mul(obj[j][0], ut.get(i, j))));
      obj[i][0] = oper.mul(c, oper.inv(ut.get(i, i)));
    }
    return new Matrix(obj, oper);
  }

  public synchronized Matrix<T> matrixInverse(MatrixScalarOperations oper) {
    if (myRows != myColumns) throw new IllegalArgumentException();
    Matrix unit = new Matrix<T>(myRows, deltaFunc, oper);
    Matrix ut = this.UTform(unit, oper);
    for (int i = myRows - 1; i >= 0; i--) {
      Object a = oper.inv(ut.get(i, i));
      Object c = oper.neg(a);
      for (int j = 0; j < i; j++) {
        Object coo = oper.mul(c, ut.get(j, i));
        ut.addRow(i, j, coo);
        unit.addRow(i, j, coo);
      }
      for (int j = 0; j < myColumns; j++)
        unit.myCarrier[i][j] = oper.mul(unit.myCarrier[i][j], a);
    }
    return unit;
  }

  private MatrixScalarOperations getI(Object o) {
    if (o instanceof Byte) return soInt;
    if (o instanceof Short) return soInt;
    if (o instanceof Integer) return soInt;
    if (o instanceof Long) return soLong;
    if (o instanceof Float) return soFloat;
    if (o instanceof Double) return soDouble;
    if (o instanceof BigInteger) return soBigInteger;
    if (o instanceof BigDecimal) return soBigDecimal;
    if (o instanceof Complex) return soDouble;
    if (o instanceof BigComplex) return soBigDecimal;
    return null;
  }

  private MatrixScalarOperations getF(Object o) {
    if (o instanceof Byte) return soDouble;
    if (o instanceof Short) return soDouble;
    if (o instanceof Integer) return soDouble;
    if (o instanceof Long) return soDouble;
    if (o instanceof Float) return soFloat;
    if (o instanceof Double) return soDouble;
    if (o instanceof BigInteger) return soBigDecimal;
    if (o instanceof BigDecimal) return soBigDecimal;
    if (o instanceof Complex) return soDouble;
    if (o instanceof BigComplex) return soBigDecimal;
    return null;
  }

  public synchronized Object matrixNorm(NormKind n) {

    boolean fValue = n == NormKind.Norm2F;
    MatrixScalarOperations oper;

    if (fValue) oper = getF(myCarrier[0][0]);
    else oper = getI(myCarrier[0][0]);

    if (oper == null) throw new IllegalArgumentException();

    switch (n) {
      case Norm1:
        Object leader = null;
        for (int j = 0; j < myColumns; j++) {
          Object o1 = 0;
          for (int i = 0; i < myRows; i++) o1 = oper.add(o1, myCarrier[i][j]);
          if (leader == null || ((Comparable) leader).compareTo(o1) < 0) leader = o1;
        }
        return leader;
      case NormInfty:
        leader = null;
        for (int i = 0; i < myRows; i++) {
          Object o1 = 0;
          for (int j = 0; j < myColumns; j++) o1 = oper.add(o1, myCarrier[i][j]);
          if (leader == null || ((Comparable) leader).compareTo(o1) < 0) leader = o1;
        }
        return leader;
      case Norm2F:
        Object o1 = 0;
        for (int i = 0; i < myRows; i++)
          for (int j = 0; j < myColumns; j++) {
            Object o = myCarrier[i][j];
            o1 = oper.add(o1, oper.mul(myOperations.abs(o), myOperations.abs(o)));
          }
        if (o1 instanceof BigDecimal) return MathRuntime.sqrt((BigDecimal) o1, MathContext.DECIMAL128);
        if (o1 instanceof Double) return Math.sqrt((Double) o1);
        if (o1 instanceof Float) return (float) Math.sqrt((Float) o1);
        return null;
      case NormMax:
        leader = null;
        for (int i = 0; i < myRows; i++)
          for (int j = 0; j < myColumns; j++) {
            Object o2 = myOperations.abs(myCarrier[i][j]);
            if (leader == null || ((Comparable) leader).compareTo(((Comparable) o2)) < 0) leader = o2;
          }
        return leader;
    }
    return null;
  }
}

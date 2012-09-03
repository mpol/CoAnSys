/*
 * (C) 2010-2012 ICM UW. All rights reserved.
 */

package pl.edu.icm.coansys.importers.models;

public final class DocumentProtosWrapper {
  private DocumentProtosWrapper() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface DocumentWrapperOrBuilder
      extends com.google.protobuf.MessageOrBuilder {
    
    // required bytes rowId = 1;
    boolean hasRowId();
    com.google.protobuf.ByteString getRowId();
    
    // required bytes mproto = 2;
    boolean hasMproto();
    com.google.protobuf.ByteString getMproto();
    
    // required bytes cproto = 3;
    boolean hasCproto();
    com.google.protobuf.ByteString getCproto();
  }
  public static final class DocumentWrapper extends
      com.google.protobuf.GeneratedMessage
      implements DocumentWrapperOrBuilder {
    // Use DocumentWrapper.newBuilder() to construct.
    private DocumentWrapper(Builder builder) {
      super(builder);
    }
    private DocumentWrapper(boolean noInit) {}
    
    private static final DocumentWrapper defaultInstance;
    public static DocumentWrapper getDefaultInstance() {
      return defaultInstance;
    }
    
    public DocumentWrapper getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.internal_static_DocumentWrapper_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.internal_static_DocumentWrapper_fieldAccessorTable;
    }
    
    private int bitField0_;
    // required bytes rowId = 1;
    public static final int ROWID_FIELD_NUMBER = 1;
    private com.google.protobuf.ByteString rowId_;
    public boolean hasRowId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    public com.google.protobuf.ByteString getRowId() {
      return rowId_;
    }
    
    // required bytes mproto = 2;
    public static final int MPROTO_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString mproto_;
    public boolean hasMproto() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    public com.google.protobuf.ByteString getMproto() {
      return mproto_;
    }
    
    // required bytes cproto = 3;
    public static final int CPROTO_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString cproto_;
    public boolean hasCproto() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    public com.google.protobuf.ByteString getCproto() {
      return cproto_;
    }
    
    private void initFields() {
      rowId_ = com.google.protobuf.ByteString.EMPTY;
      mproto_ = com.google.protobuf.ByteString.EMPTY;
      cproto_ = com.google.protobuf.ByteString.EMPTY;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;
      
      if (!hasRowId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasMproto()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasCproto()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeBytes(1, rowId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, mproto_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, cproto_);
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(1, rowId_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, mproto_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, cproto_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }
    
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapperOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.internal_static_DocumentWrapper_descriptor;
      }
      
      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.internal_static_DocumentWrapper_fieldAccessorTable;
      }
      
      // Construct using pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }
      
      private Builder(BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }
      
      public Builder clear() {
        super.clear();
        rowId_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        mproto_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000002);
        cproto_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.getDescriptor();
      }
      
      public pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper getDefaultInstanceForType() {
        return pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.getDefaultInstance();
      }
      
      public pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper build() {
        pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }
      
      private pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return result;
      }
      
      public pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper buildPartial() {
        pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper result = new pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.rowId_ = rowId_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.mproto_ = mproto_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.cproto_ = cproto_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper) {
          return mergeFrom((pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper other) {
        if (other == pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.getDefaultInstance()) return this;
        if (other.hasRowId()) {
          setRowId(other.getRowId());
        }
        if (other.hasMproto()) {
          setMproto(other.getMproto());
        }
        if (other.hasCproto()) {
          setCproto(other.getCproto());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public final boolean isInitialized() {
        if (!hasRowId()) {
          
          return false;
        }
        if (!hasMproto()) {
          
          return false;
        }
        if (!hasCproto()) {
          
          return false;
        }
        return true;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              onChanged();
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                onChanged();
                return this;
              }
              break;
            }
            case 10: {
              bitField0_ |= 0x00000001;
              rowId_ = input.readBytes();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              mproto_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              cproto_ = input.readBytes();
              break;
            }
          }
        }
      }
      
      private int bitField0_;
      
      // required bytes rowId = 1;
      private com.google.protobuf.ByteString rowId_ = com.google.protobuf.ByteString.EMPTY;
      public boolean hasRowId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      public com.google.protobuf.ByteString getRowId() {
        return rowId_;
      }
      public Builder setRowId(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000001;
        rowId_ = value;
        onChanged();
        return this;
      }
      public Builder clearRowId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        rowId_ = getDefaultInstance().getRowId();
        onChanged();
        return this;
      }
      
      // required bytes mproto = 2;
      private com.google.protobuf.ByteString mproto_ = com.google.protobuf.ByteString.EMPTY;
      public boolean hasMproto() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      public com.google.protobuf.ByteString getMproto() {
        return mproto_;
      }
      public Builder setMproto(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        mproto_ = value;
        onChanged();
        return this;
      }
      public Builder clearMproto() {
        bitField0_ = (bitField0_ & ~0x00000002);
        mproto_ = getDefaultInstance().getMproto();
        onChanged();
        return this;
      }
      
      // required bytes cproto = 3;
      private com.google.protobuf.ByteString cproto_ = com.google.protobuf.ByteString.EMPTY;
      public boolean hasCproto() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      public com.google.protobuf.ByteString getCproto() {
        return cproto_;
      }
      public Builder setCproto(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        cproto_ = value;
        onChanged();
        return this;
      }
      public Builder clearCproto() {
        bitField0_ = (bitField0_ & ~0x00000004);
        cproto_ = getDefaultInstance().getCproto();
        onChanged();
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:DocumentWrapper)
    }
    
    static {
      defaultInstance = new DocumentWrapper(true);
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:DocumentWrapper)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_DocumentWrapper_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_DocumentWrapper_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020bw2Wrapper.proto\"@\n\017DocumentWrapper\022\r\n" +
      "\005rowId\030\001 \002(\014\022\016\n\006mproto\030\002 \002(\014\022\016\n\006cproto\030\003" +
      " \002(\014B<\n#pl.edu.icm.coansys.importers.mod" +
      "elsB\025DocumentProtosWrapper"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_DocumentWrapper_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_DocumentWrapper_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_DocumentWrapper_descriptor,
              new java.lang.String[] { "RowId", "Mproto", "Cproto", },
              pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.class,
              pl.edu.icm.coansys.importers.models.DocumentProtosWrapper.DocumentWrapper.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  // @@protoc_insertion_point(outer_class_scope)
}

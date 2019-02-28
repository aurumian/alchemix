package iad.model;

import javax.persistence.*;

@Entity
public class File {
    @Id
    @Column(name = "file_id")
    @SequenceGenerator(name = "file_seq", sequenceName = "file_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "file_seq")
    private Long fileId;

    @Column(unique = true, nullable = false)
    private String filename;

    @Column(nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private byte[] data;

    public File(){

    }

    public File(String filename, byte[] data){
        this.filename = filename;
        this.data = data;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
